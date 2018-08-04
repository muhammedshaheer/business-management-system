package com.bms.web.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Agreement;
import com.bms.domain.Customer;
import com.bms.domain.Invoice;
import com.bms.domain.Payment;
import com.bms.domain.PaymentMilestone;
import com.bms.domain.Prospect;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateInvoiceAction extends AbstractAction {

	public static final String NEXT_PAGE = "forward:ViewInvoice.jsp";

	List<PaymentMilestone> milestoneList;

	List<Payment> paymentList;

	List<Prospect> prospectList;

	List<Agreement> agreementList;

	List<Customer> customerList;

	List<Invoice> invoiceList;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		this.milestoneList = paymentMilestoneService.listMilestones();

		this.paymentList = paymentService.listPayment();

		this.prospectList = prospectService.listProspects();

		this.agreementList = agreementService.listAgreements();

		this.customerList = customerService.listCustomers();

		this.invoiceList = invoiceService.listInvoice();

		String id = request.getParameter("milestoneId");

		Integer milestoneId = null;

		if (null != id) {

			milestoneId = Integer.parseInt(id);
		}

		else {
			throw new RuntimeException("error while taking milestone id");

		}

		Invoice invoice = new Invoice();

		if (null != milestoneList) {
			for (PaymentMilestone milestone : milestoneList) {

				if (milestone.getMilestoneId().equals(milestoneId)) {

					invoice = getInvoiceObj(milestone);

					invoiceService.updateInvoice(invoice);

					generateInvoiceFile(invoice);

					request.setAttribute("invoice", invoice);

				}
			}
		} else {
			throw new RuntimeException("error while getting milestone list");

		}

		return NEXT_PAGE;
	}

	private Invoice getInvoiceObj(PaymentMilestone milestone) {

		Invoice invoice = new Invoice();

		for (Invoice invoiceInList : invoiceList) {
			if (invoiceInList.getMilestoneId().equals(
					milestone.getMilestoneId())) {
				invoice.setInvoiceNo(invoiceInList.getInvoiceNo());
			}
		}

		invoice.setMilestoneId(milestone.getMilestoneId());

		invoice.setAmount(milestone.getAmount());

		invoice.setDescription(milestone.getDescription());

		invoice.setPaymentDueDate(milestone.getDueDate());

		Date date = new Date();

		invoice.setInvoiceDate(date);

		invoice.setCustomerName(getCustomerName(milestone));

		String root = (GenerateReportAction.class
				.getResource("GenerateInvoiceAction.class")).toString();

		String[] rootPathList = root.split("/.metadata");

		root = rootPathList[0];

		rootPathList = root.split("file:/");

		root = rootPathList[1];

		root = root.replaceAll("%20", " ");

		root = root.replace('/', '\\');

		String BASE_LOCATION = root + "\\bms\\files\\invoice\\";

		String fileName = "invoice" + invoice.getInvoiceNo() + ".pdf";

		invoice.setLinkToFile(BASE_LOCATION + fileName);

		return invoice;
	}

	private String getCustomerName(PaymentMilestone paymentMilestone) {

		String customerName = null;

		Integer paymentId = paymentMilestone.getPaymentId();

		for (Payment payment : paymentList) {

			if (payment.getPaymentId().equals(paymentId)) {

				Integer agreementId = payment.getAgreementId();

				for (Agreement agreement : agreementList) {

					if (agreement.getAgreementId().equals(agreementId)) {

						Integer prospectId = agreement.getProspectId();

						for (Prospect prospect : prospectList) {

							if (prospect.getProspectID().equals(prospectId)) {

								Integer customerId = prospect.getCustomerID();

								for (Customer customer : customerList) {

									if (customer.getCustomerID().equals(
											customerId)) {

										customerName = customer
												.getCustomerName();

									}
								}
							}

						}

					}

				}

			}

		}

		return customerName;

	}

	private void generateInvoiceFile(Invoice invoice) {

		Document document = new Document();
		String filePath = invoice.getLinkToFile();
		System.out.println("there");

		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(filePath));

			document.open();
			document.addAuthor("Ospyn");
			document.addTitle("Invoice");
			
			Font fontHead = new Font(Font.FontFamily.TIMES_ROMAN);
			fontHead.setStyle(Font.BOLD);
			fontHead.setStyle(Font.UNDERLINE);
			fontHead.setSize(20);
			
			Paragraph head = new Paragraph();
			head.setFont(fontHead);
			head.add("INVOICE");
			head.setAlignment(Element.ALIGN_JUSTIFIED);
			head.setAlignment(Element.ALIGN_CENTER);
			head.setSpacingAfter(36f);
			head.setSpacingBefore(72f);
			
			Font fontp = new Font(Font.FontFamily.HELVETICA);
			fontp.setStyle(Font.NORMAL);
			fontp.setSize(14);
			
			Paragraph paragraph = new Paragraph();
			paragraph.setFont(fontp);
			paragraph.add("Ospyn Technologies Pvt. Ltd.");
			paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			document.add(head);

			PdfPTable table = new PdfPTable(new float[] { 2, 2 });
			table.setSpacingAfter(72f);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell("Invoice No");
			table.addCell(String.valueOf(invoice.getInvoiceNo()));
			table.addCell("Invoice Date");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = invoice.getInvoiceDate();
			table.addCell(formatter.format(date));
			table.addCell("Customer");
			table.addCell(invoice.getCustomerName());
			table.addCell("Due Amount");
			table.addCell(String.valueOf(invoice.getAmount()));
			table.addCell("Description");
			table.addCell(invoice.getDescription());
			table.addCell("Payment Due Date");
			table.addCell(formatter.format(invoice.getPaymentDueDate()));
			document.add(table);
			/*
			 * document.add(new Paragraph(invoice.getInvoiceNo()));
			 * 
			 * document.add(new Paragraph(formatter.format(date)));
			 * document.add(new Paragraph("customer" +
			 * invoice.getCustomerName())); document.add(new Paragraph("amount:"
			 * + invoice.getAmount())); document.add(new
			 * Paragraph(invoice.getDescription())); document.add(new
			 * Paragraph("Payment Due Date:"+
			 * formatter.format(invoice.getPaymentDueDate())));
			 */
			document.close();
			writer.close();
			System.out.println("PDF made");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
