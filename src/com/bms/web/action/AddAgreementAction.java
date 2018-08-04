package com.bms.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bms.domain.Agreement;
import com.bms.util.FileUpload;

public class AddAgreementAction extends AbstractAction {

	private static final String NEXT_PAGE = "redirect:listAgreement.do";

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String MSG = "message";

	private static final Object SUCCESS_MSG = "agreement added";
	

	synchronized public String execute(HttpServletRequest request,HttpServletResponse response) {

		String value = null;

		Agreement agreement = new Agreement();

		if (ServletFileUpload.isMultipartContent(request)) {

			try {

				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {

					value = null;

					if (item.isFormField()) {

						String name = item.getFieldName();

						value = item.getString();

						if (null != value) {

							switch (name) {
							
							case "agreementId":
								
								agreement.setAgreementId(Integer.parseInt(value));
							
								break;

							case "prospectId":
								
								agreement.setProspectId(Integer.parseInt(value));
							
								break;

							case "estimateAmount":
								
								agreement.setEstimateAmount(Double.parseDouble(value));
							
								break;
								

							case "periodOfContract":
								
								agreement.setPeriodOfContract(Integer.parseInt(value));
							
								break;
							
                            case "terminationConditions":
								
								agreement.setTerminationConditions(value);
							
								break;
							
                            case "confirm":
                            
                            	agreement.setConfirm(Boolean.valueOf(value));
    							
								break;
						
                            case "finishingDate":
                                
                                Date finishingDate = new SimpleDateFormat(DATE_FORMAT).parse(value);
                            	
                            	agreement.setFinishingDate(finishingDate);
								
                            case "dateOfAgreement":
                                
                            	Date dateOfAgreement = new SimpleDateFormat(DATE_FORMAT).parse(value);
                            	
                            	agreement.setDateOfAgreement(dateOfAgreement);
    							
								break;	
								
								}
						}
					}
					else{
						
						int maxID = agreementService.getMaxID();
						
						String linkToFile = FileUpload.doUpload(item, "agreement",maxID);
						
						agreement.setLinkToFile(linkToFile);
						
					}
				}
			} catch (Exception e) {

				e.printStackTrace();

			}

		}

			agreementService.addAgreement(agreement);

			request.setAttribute(MSG, SUCCESS_MSG);
			
       return NEXT_PAGE;
	}
	

}
