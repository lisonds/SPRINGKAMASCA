package unsch.edu.pe.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import unsch.edu.pe.model.entity.Factura;
import unsch.edu.pe.model.entity.Ventas;
import unsch.edu.pe.model.entity.ventaMes;
import unsch.edu.pe.service.IVentaMesService;
import unsch.edu.pe.service.IventasService;




@Controller
@RequestMapping(value="/panel")
public class ventaController {
	Month mes = LocalDate.now().getMonth();
	private double total;
	@Autowired
	private IventasService serviceventas;
	
	@PostMapping("/save")
	public String GuardarVentas(Ventas ventas,BindingResult result) {
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}	
			return "views/ventasForm";
		}
		System.out.println("ventas= "+ventas);
		Factura fact=new Factura();
		
		fact.setIdfactura(0000000002);
		ventas.setFactura(fact);
		serviceventas.guardar(ventas);
		
		
		
		
		return "redirect:/panel/ventas";
	}
	
	@GetMapping("/form")
	public String formventas() {
		
		
		return "views/ventasForm";
	}
	
	/*	@GetMapping("/guarda")
	public String GuardarVentas() {
		Ventas ventas=new Ventas();
		ventas.setIdventas(6);
		ventas.setNumboleta("128");
		ventas.setProducto("gigantofrafiaLis");
		ventas.setClasificacion("giganto");
		ventas.setFecha(new Date());
		ventas.setCosto(305.20);
		ventas.setCancelado(0);
		Factura fac=new Factura();
		fac.setIdfactura(0000000001);
		ventas.setFactura(fac);
		serviceventas.guardar(ventas);
		return "views/ventas";
	}*/
	
	@GetMapping("/ventas")
	public String ventas(Model model) {
		total=0;
		double totalnopaga=0;
		List<Ventas> lista=serviceventas.buscarTodas();
		for(Ventas v:lista) {
			System.out.println("COSTOS:"+v.getCosto());
			total=total+v.getCosto();
			if(v.getCancelado()==0) {
				totalnopaga=totalnopaga+v.getCosto();
			}
			
		}
		System.out.println("totales: "+total);
		System.out.println("total no paga: "+totalnopaga);
		
		System.out.println(lista);
		model.addAttribute("Ventas", lista);
		model.addAttribute("total", "S/ "+total);
		model.addAttribute("nopago", "S/ "+totalnopaga);

		String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		System.out.println("El mes es="+nombreMes);
		model.addAttribute("fechaactual", nombreMes);
		
		
		
		return "views/ventas";
	}
	
	
	
	

	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
		
	}

}
