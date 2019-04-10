package com.agilefaqs.legacy;

import untouchable.AssetReport;
import untouchable.RecordSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AssetReportServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      RecordSet records = (RecordSet) request.getAttribute("queryResult");
		  PrintWriter writer = response.getWriter();
		   new AssetReport(records, writer).invoke();
	   }


}
