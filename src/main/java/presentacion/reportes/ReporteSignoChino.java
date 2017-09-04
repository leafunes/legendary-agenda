package presentacion.reportes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.reportes.PersonaReporteDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteSignoChino{
	
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	
	private final static String jasperTemplate = "reportes"+File.separatorChar+"ReporteSignoChino.jrxml";
	private final static String reporteLocation = "reportes"+File.separatorChar+"ReporteSignoChino.jasper";
	
	//Recibe la lista de personas para armar el reporte
    public ReporteSignoChino(List<PersonaReporteDTO> personas){
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

    	try		{
    		if (! new File(reporteLocation).exists())JasperCompileManager.compileReportToFile(
                    jasperTemplate,
                    reporteLocation);
    		
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile(reporteLocation);
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(personas));
		}
		catch( JRException ex ) 
		{
			ex.printStackTrace();
		}
    }       
    
    public void mostrar(){
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setTitle("Reporte Contactos - Signo Chino");
		this.reporteViewer.setVisible(true);
	}
   
}	
