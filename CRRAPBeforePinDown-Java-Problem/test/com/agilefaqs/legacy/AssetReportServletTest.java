package com.agilefaqs.legacy;

import static org.junit.Assert.*;

import org.junit.Test;
import untouchable.RecordSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

public class AssetReportServletTest {

	@Test
	public void yourTestName() throws ServletException, IOException {
		HttpServletResponse response = new HttpServletResponse() {
			@Override
			public void addCookie(Cookie cookie) {

			}

			@Override
			public boolean containsHeader(String s) {
				return false;
			}

			@Override
			public String encodeURL(String s) {
				return null;
			}

			@Override
			public String encodeRedirectURL(String s) {
				return null;
			}

			@Override
			public String encodeUrl(String s) {
				return null;
			}

			@Override
			public String encodeRedirectUrl(String s) {
				return null;
			}

			@Override
			public void sendError(int i, String s) throws IOException {

			}

			@Override
			public void sendError(int i) throws IOException {

			}

			@Override
			public void sendRedirect(String s) throws IOException {

			}

			@Override
			public void setDateHeader(String s, long l) {

			}

			@Override
			public void addDateHeader(String s, long l) {

			}

			@Override
			public void setHeader(String s, String s1) {

			}

			@Override
			public void addHeader(String s, String s1) {

			}

			@Override
			public void setIntHeader(String s, int i) {

			}

			@Override
			public void addIntHeader(String s, int i) {

			}

			@Override
			public void setStatus(int i) {

			}

			@Override
			public void setStatus(int i, String s) {

			}

			@Override
			public String getCharacterEncoding() {
				return null;
			}

			@Override
			public String getContentType() {
				return null;
			}

			@Override
			public ServletOutputStream getOutputStream() throws IOException {
				return null;
			}

			@Override
			public PrintWriter getWriter() throws IOException {
				PrintWriter writer = new PrintWriter("");
				return writer;
			}

			@Override
			public void setCharacterEncoding(String s) {

			}

			@Override
			public void setContentLength(int i) {

			}

			@Override
			public void setContentType(String s) {

			}

			@Override
			public void setBufferSize(int i) {

			}

			@Override
			public int getBufferSize() {
				return 0;
			}

			@Override
			public void flushBuffer() throws IOException {

			}

			@Override
			public void resetBuffer() {

			}

			@Override
			public boolean isCommitted() {
				return false;
			}

			@Override
			public void reset() {

			}

			@Override
			public void setLocale(Locale locale) {

			}

			@Override
			public Locale getLocale() {
				return null;
			}
		};

		HttpServletRequest request = new HttpServletRequest() {
			@Override
			public String getAuthType() {
				return null;
			}

			@Override
			public Cookie[] getCookies() {
				return new Cookie[0];
			}

			@Override
			public long getDateHeader(String s) {
				return 0;
			}

			@Override
			public String getHeader(String s) {
				return null;
			}

			@Override
			public Enumeration getHeaders(String s) {
				return null;
			}

			@Override
			public Enumeration getHeaderNames() {
				return null;
			}

			@Override
			public int getIntHeader(String s) {
				return 0;
			}

			@Override
			public String getMethod() {
				return null;
			}

			@Override
			public String getPathInfo() {
				return null;
			}

			@Override
			public String getPathTranslated() {
				return null;
			}

			@Override
			public String getContextPath() {
				return null;
			}

			@Override
			public String getQueryString() {
				return null;
			}

			@Override
			public String getRemoteUser() {
				return null;
			}

			@Override
			public boolean isUserInRole(String s) {
				return false;
			}

			@Override
			public Principal getUserPrincipal() {
				return null;
			}

			@Override
			public String getRequestedSessionId() {
				return null;
			}

			@Override
			public String getRequestURI() {
				return null;
			}

			@Override
			public StringBuffer getRequestURL() {
				return null;
			}

			@Override
			public String getServletPath() {
				return null;
			}

			@Override
			public HttpSession getSession(boolean b) {
				return null;
			}

			@Override
			public HttpSession getSession() {
				return null;
			}

			@Override
			public boolean isRequestedSessionIdValid() {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromCookie() {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromURL() {
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromUrl() {
				return false;
			}

			@Override
			public Object getAttribute(String s) {
				String[] fields = new String[1];
				fields[0] = "";
				String[][] rows = new String[1][1];
				rows[0][0] = "";
				RecordSet records = new RecordSet(fields,rows);
				return records;
			}

			@Override
			public Enumeration getAttributeNames() {
				return null;
			}

			@Override
			public String getCharacterEncoding() {
				return null;
			}

			@Override
			public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

			}

			@Override
			public int getContentLength() {
				return 0;
			}

			@Override
			public String getContentType() {
				return null;
			}

			@Override
			public ServletInputStream getInputStream() throws IOException {
				return null;
			}

			@Override
			public String getParameter(String s) {
				return null;
			}

			@Override
			public Enumeration getParameterNames() {
				return null;
			}

			@Override
			public String[] getParameterValues(String s) {
				return new String[0];
			}

			@Override
			public Map getParameterMap() {
				return null;
			}

			@Override
			public String getProtocol() {
				return null;
			}

			@Override
			public String getScheme() {
				return null;
			}

			@Override
			public String getServerName() {
				return null;
			}

			@Override
			public int getServerPort() {
				return 0;
			}

			@Override
			public BufferedReader getReader() throws IOException {
				return null;
			}

			@Override
			public String getRemoteAddr() {
				return null;
			}

			@Override
			public String getRemoteHost() {
				return null;
			}

			@Override
			public void setAttribute(String s, Object o) {


			}

			@Override
			public void removeAttribute(String s) {

			}

			@Override
			public Locale getLocale() {
				return null;
			}

			@Override
			public Enumeration getLocales() {
				return null;
			}

			@Override
			public boolean isSecure() {
				return false;
			}

			@Override
			public RequestDispatcher getRequestDispatcher(String s) {
				return null;
			}

			@Override
			public String getRealPath(String s) {
				return null;
			}

			@Override
			public int getRemotePort() {
				return 0;
			}

			@Override
			public String getLocalName() {
				return null;
			}

			@Override
			public String getLocalAddr() {
				return null;
			}

			@Override
			public int getLocalPort() {
				return 0;
			}
		};
		String[] fields = new String[1];
		fields[0] = "";
		String[][] rows = new String[1][1];
		rows[0][0] = "";
		RecordSet records = new RecordSet(fields,rows);
		request.setAttribute("queryResult",records);
		new AssetReportServlet().doPost(request,response);
	}

}
