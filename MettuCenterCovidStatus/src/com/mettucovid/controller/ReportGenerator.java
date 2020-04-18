package com.mettucovid.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mettucovid.util.ConnectionUtil;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * Servlet implementation class ReportGenerator
 */
@WebServlet("/ReportGenerator")
public class ReportGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ConnectionUtil.getConnection();
		JasperReportBuilder report = DynamicReports.report();//a new report
		report
		  .columns(
		      Columns.column("Patient Id", "patientId", DataTypes.integerType()),
		      Columns.column("First Name", "firstName", DataTypes.stringType()),
		      Columns.column("Last Name", "lastName", DataTypes.stringType()),
		      Columns.column("Age", "age", DataTypes.integerType()))
		  .title(//title of the report
		      Components.text("Patient Details")
			  .setHorizontalAlignment(HorizontalAlignment.CENTER))
			  .pageFooter(Components.pageXofY())//show page number on the page footer
			  .setDataSource("SELECT patientId,firstName, lastName, age FROM patients", 
	                                  conn);

		try {
	                //show the report
			report.show();
			report.toPdf(new FileOutputStream("report.pdf"));
			request.getRequestDispatcher("AdminHome").forward(request, response);
	                //export the report to a pdf file
			
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
