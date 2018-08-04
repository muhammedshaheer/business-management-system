package com.bms.web.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class GenerateReportAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:downloadFile.do";

	@SuppressWarnings({ "deprecation" })
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String reportType = request.getParameter("reportType");
		
		int count = 0;
		int acceptedCount = 0;
		int pendingCount = 0;
		int rejectedCount = 0;
		
		String fname = null;
		
		Date today = new Date();
		today.setHours(0);
		
		String to = "_ " + today; //_ Tue Jul 24 00:34:51 IST 2018
		
		String[] toList = to.split(" ");
		
		to = toList[0] + toList[3] + "_" + toList[2] + "_" + toList[6];
		
		String hd = null;
		
		if(reportType.equals("prospect")){
			count = prospectService.count();
			acceptedCount = prospectService.acceptedProspectsCount();
			pendingCount = prospectService.pendingProspectsCount();
			rejectedCount = prospectService.rejectedProspectsCount();
			fname = "Prospect_Report" + to;
			hd = "Prospect Statistics and Analysis Report";
		} else if(reportType.equals("proposal")){
			count = proposalService.count();
			acceptedCount = proposalService.acceptedProposalsCount();
			fname = "Proposal_Report" + to;
			hd = "Proposal Statistics and Analysis Report";
		} else if(reportType.equals("agreement")) {
			count = agreementService.count();
			acceptedCount = agreementService.confirmedAgreementCount();
			fname = "Agreement_Report" + to;
			hd = "Agreement Statistics and Analysis Report";
		}
		
		double acceptedPercentage = ((double)acceptedCount/(double)count)*100;
		
		acceptedPercentage = (double)Math.round(acceptedPercentage * 100d) / 100d;
		
		try {
			
			String root = (GenerateReportAction.class.getResource("GenerateReportAction.class")).toString();
			
		 	String[] rootPathList = root.split("/.metadata");
		 	
		 	root = rootPathList[0];
		 	
		 	rootPathList = root.split("file:/");
		 	
		 	root = rootPathList[1];
		 	
		 	root = root.replaceAll("%20", " ");
		 	
		 	root = root.replace('/', '\\');
		 	
		 	String BASE_LOCATION = root + "\\bms\\files\\reports\\";
			
			String LOCATION = BASE_LOCATION;
			
			FileOutputStream fileout = new FileOutputStream(LOCATION + fname +".pdf");
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			document.addAuthor("Ospyn");
			document.addTitle(fname);

			document.open();

			Font fontHead = new Font(Font.FontFamily.TIMES_ROMAN);
			fontHead.setStyle(Font.BOLD);
			fontHead.setStyle(Font.UNDERLINE);
			fontHead.setSize(20);

			Font fontp = new Font(Font.FontFamily.HELVETICA);
			fontp.setStyle(Font.NORMAL);
			fontp.setSize(14);
			
			Paragraph head = new Paragraph();
			head.setFont(fontHead);
			head.add(hd);
			head.setAlignment(Element.ALIGN_JUSTIFIED);
			head.setAlignment(Element.ALIGN_CENTER);
			head.setSpacingAfter(36f);
			head.setSpacingBefore(72f);

			Paragraph paragraph = new Paragraph();
			paragraph.setFont(fontp);
			paragraph.add("Ospyn Technologies Pvt. Ltd.");
			paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setSpacingAfter(72f);
			
			PdfPTable table = new PdfPTable(2);
			table.setSpacingAfter(72f);
			
			Paragraph percentage = new Paragraph();
			percentage.setFont(fontp);
			percentage.setAlignment(Element.ALIGN_JUSTIFIED);
			percentage.setAlignment(Element.ALIGN_RIGHT);
			percentage.setSpacingAfter(36f);
			
			if(reportType.equals("prospect")){
				table.addCell("Total");
				table.addCell(String.valueOf(count));
				table.addCell("Accepted");
				table.addCell(String.valueOf(acceptedCount));
				table.addCell("Pending");
				table.addCell(String.valueOf(pendingCount));
				table.addCell("Rejected");
				table.addCell(String.valueOf(rejectedCount));
				percentage.add(acceptedPercentage + "% of all prospects have been accepted.");
			} else if(reportType.equals("proposal")){
				table.addCell("Total");
				table.addCell(String.valueOf(count));
				table.addCell("Accepted");
				table.addCell(String.valueOf(acceptedCount));
				percentage.add(acceptedPercentage + "% of all proposals have been accepted.");
			} else if(reportType.equals("agreement")) {
				table.addCell("Total");
				table.addCell(String.valueOf(count));
				table.addCell("Accepted");
				table.addCell(String.valueOf(acceptedCount));
				percentage.add(acceptedPercentage + "% of all agreements have been confirmed.");
			}
			
			Paragraph footer = new Paragraph();
			footer.setAlignment(Element.ALIGN_JUSTIFIED);
			footer.setAlignment(Element.ALIGN_RIGHT);
			footer.add("This report was generated on " + today);
		
			document.add(head);
			document.add(paragraph);
			document.add(table);
			document.add(percentage);
			document.add(footer);
			document.close();
			
			request.setAttribute("url", LOCATION + fname +".pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return NEXT_PAGE;
	}

}
