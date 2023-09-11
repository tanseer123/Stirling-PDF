package stirling.software.SPDF.controller.api.converters;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import stirling.software.SPDF.model.api.GeneralFile;
import stirling.software.SPDF.model.api.PDFFile;
import stirling.software.SPDF.model.api.converters.PdfToPresentationRequest;
import stirling.software.SPDF.model.api.converters.PdfToTextOrRTFRequest;
import stirling.software.SPDF.model.api.converters.PdfToWordRequest;
import stirling.software.SPDF.utils.PDFToFile;

@RestController
@RequestMapping("/api/v1/convert")
@Tag(name = "Convert", description = "Convert APIs")
public class ConvertPDFToOffice {

	@PostMapping(consumes = "multipart/form-data", value = "/pdf/html")
	@Operation(summary = "Convert PDF to HTML", description = "This endpoint converts a PDF file to HTML format. Input:PDF Output:HTML Type:SISO")
	public ResponseEntity<byte[]> processPdfToHTML(@ModelAttribute PDFFile request) 
	        throws Exception {
		MultipartFile inputFile = request.getFileInput();
		PDFToFile pdfToFile = new PDFToFile();
		return pdfToFile.processPdfToOfficeFormat(inputFile, "html", "writer_pdf_import");
	}

	@PostMapping(consumes = "multipart/form-data", value = "/pdf/presentation")
	@Operation(summary = "Convert PDF to Presentation format", description = "This endpoint converts a given PDF file to a Presentation format. Input:PDF Output:PPT Type:SISO")
	public ResponseEntity<byte[]> processPdfToPresentation(@ModelAttribute PdfToPresentationRequest request) throws IOException, InterruptedException {
	    MultipartFile inputFile = request.getFileInput();
	    String outputFormat = request.getOutputFormat();
		PDFToFile pdfToFile = new PDFToFile();
		return pdfToFile.processPdfToOfficeFormat(inputFile, outputFormat, "impress_pdf_import");
	}

	@PostMapping(consumes = "multipart/form-data", value = "/pdf/text")
	@Operation(summary = "Convert PDF to Text or RTF format", description = "This endpoint converts a given PDF file to Text or RTF format. Input:PDF Output:TXT Type:SISO")
	public ResponseEntity<byte[]> processPdfToRTForTXT(@ModelAttribute PdfToTextOrRTFRequest request) throws IOException, InterruptedException {
	    MultipartFile inputFile = request.getFileInput();
	    String outputFormat = request.getOutputFormat();

		PDFToFile pdfToFile = new PDFToFile();
		return pdfToFile.processPdfToOfficeFormat(inputFile, outputFormat, "writer_pdf_import");
	}

	@PostMapping(consumes = "multipart/form-data", value = "/pdf/word")
	@Operation(summary = "Convert PDF to Word document", description = "This endpoint converts a given PDF file to a Word document format. Input:PDF Output:WORD Type:SISO")
	public ResponseEntity<byte[]> processPdfToWord(@ModelAttribute PdfToWordRequest request) throws IOException, InterruptedException {
	    MultipartFile inputFile = request.getFileInput();
	    String outputFormat = request.getOutputFormat();
		PDFToFile pdfToFile = new PDFToFile();
		return pdfToFile.processPdfToOfficeFormat(inputFile, outputFormat, "writer_pdf_import");
	}

	@PostMapping(consumes = "multipart/form-data", value = "/pdf/xml")
	@Operation(summary = "Convert PDF to XML", description = "This endpoint converts a PDF file to an XML file. Input:PDF Output:XML Type:SISO")
	public ResponseEntity<byte[]> processPdfToXML(@ModelAttribute PDFFile request) 
	        throws Exception {
		MultipartFile inputFile = request.getFileInput();

		PDFToFile pdfToFile = new PDFToFile();
		return pdfToFile.processPdfToOfficeFormat(inputFile, "xml", "writer_pdf_import");
	}

}
