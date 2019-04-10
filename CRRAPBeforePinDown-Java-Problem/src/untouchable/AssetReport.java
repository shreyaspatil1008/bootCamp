package untouchable;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by idnsrp on 6/8/2018.
 */
public class AssetReport {
    private RecordSet records;
    private PrintWriter writer;

    public AssetReport(RecordSet records, PrintWriter writer) {
        this.records = records;
        this.writer = writer;
    }

    public void invoke() {
        TreeMap<String, BigDecimal> groupTotal;
        TreeMap<String, BigDecimal> positions;
        BigDecimal allPositions;
        HashMap<String, BigDecimal> m_hmRiskTable;
        HashMap<String, String> assetToGroup;
        RiskAssessor assessor;
        groupTotal = new TreeMap<String, BigDecimal>();
        positions = new TreeMap<String, BigDecimal>();
        m_hmRiskTable = new HashMap<String, BigDecimal>();
        allPositions = new BigDecimal("0.00");
        assetToGroup = new HashMap<String, String>();
        for (int row = 0; row < records.getRowCount(); row++) {
            BigDecimal pos = new BigDecimal(1);
            BigDecimal r = new BigDecimal("0.00");
            String issue = new String("");
            issue = records.getItem(row, "ISSUE_NAME");
            if (records.getItem(row, "ISSUE_FAMILY").toUpperCase().startsWith("FUND")) {
                BigDecimal perItem = records.getDecimal(row, "MARKET_PRICE").subtract(records.getDecimal(row, "TERM_ONE"));
                pos = perItem.multiply(records.getDecimal(row, "QUANTITY")).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal riskCoefficient = assessor.getRiskCoefficient(records.getItem(row, "ISSUE_FAMILY"), records
                        .getDecimal(row, "TERM_TWO"));
                BigDecimal product = riskCoefficient.multiply(pos);
                r = product.divide(new BigDecimal("100.00"), 2, BigDecimal.ROUND_HALF_UP);
                positions.put(issue, pos);
            }
            else {
                pos = records.getDecimal(row, "QUANTITY").multiply(records.getDecimal(row, "MARKET_PRICE"));
                pos = pos.subtract(records.getDecimal(row, "TERM_ONE")).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal product = records.getDecimal(row, "TERM_TWO").multiply(pos);
                r = product.divide(new BigDecimal("100.00"), 2, BigDecimal.ROUND_HALF_UP);
                positions.put(issue, pos);
            }
            allPositions = allPositions.add(positions.get(issue));
            String group = records.getItem(row, "ISSUE_GROUP");
            String name = records.getItem(row, "ISSUE_NAME");
            assetToGroup.put(name, group);
            BigDecimal value = new BigDecimal("0");
            if (groupTotal.containsKey(group))
                value = value.add(groupTotal.get(group)).setScale(2);
            value = value.add(positions.get(issue));
            groupTotal.put(group, value.setScale(2));
            m_hmRiskTable.put(issue, r);
        }
        writer.write("<groups>\n");
        // groups in sorted order
        Iterator<String> g = groupTotal.keySet().iterator();
        while (g.hasNext()) {
            String grp = g.next();
            BigDecimal position = groupTotal.get(grp);
            BigDecimal product = position.multiply(new BigDecimal(100));
            BigDecimal weight = product.divide(allPositions, 2, BigDecimal.ROUND_HALF_UP);
            writer.write("\t<group position='" + position.toPlainString());
            writer.write("' weight='" + weight);
            writer.write("'>\n");
            writer.write("\t\t" + grp + "\n");
            // groups in sorted order
            Iterator<String> i = positions.keySet().iterator();
            boolean notFirstOne = false;
            while (i.hasNext()) {
                String asset = i.next();
                // Output asset only if it belongs in group
                if (assetToGroup.get(asset).equalsIgnoreCase(grp)) {
                    // add newline only if not first item
                    if (notFirstOne)
                        writer.write("\n");
                    writer.write("\t\t<asset position='" + positions.get(asset).toPlainString() + "' ");
                    BigDecimal p = positions.get(asset);
                    BigDecimal weight1 = p.multiply(new BigDecimal("100.00")).divide(position, 2, BigDecimal.ROUND_HALF_UP)
                            .setScale(2);
                    writer.write("weight='" + weight1 + "' risk='" + m_hmRiskTable.get(asset).toPlainString() + "'>\n");
                    writer.write("\t\t\t" + asset + "\n");
                    writer.write("\t\t</asset>");
                    notFirstOne = true;
                }
            }
            writer.write("\n\t</group>\n");
        }
        writer.write("</groups>\n");
    }
}
