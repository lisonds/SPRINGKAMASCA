package unsch.edu.pe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import unsch.edu.pe.Util.Utileria;
import unsch.edu.pe.model.entity.Diseniador;
import unsch.edu.pe.service.IDiseniadorService;

@Controller
@RequestMapping(value = "/panel")
public class DiseniadoresController {
	@Autowired
	private IDiseniadorService diseServi;

	@GetMapping("/disenia")
	public String Diseniadores() {

		return "views/usuarios";
	}
	@GetMapping("/disenia/trabajos")
	public String trabajos() {

		return "views/trabajos";
	}

	@GetMapping("/disenia/from")
	public String DiseniadoresFrom() {

		return "views/diseniadorFrom";
	}

	@PostMapping("/disenia/save")
	public String Guardar(Diseniador diseniador, BindingResult result,
			@RequestParam("fotoperfil") MultipartFile multiPart) {
		/*
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "views/diseniadorFrame";
		}
*/
		// para imagen
		System.out.println("LLLEGO PARA EL IMAGEN ");
		if (!multiPart.isEmpty()) {
			// String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			String ruta = "c:/diseniadores/img/"; // Windows C:\diseniadores\img
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null) { // La imagen si se subio
				// Procesamos la variable nombreImagen
				diseniador.setFotoperfil(nombreImagen);
			}
		}

		System.out.println("Diseniador :" + diseniador);
		diseServi.guardar(diseniador);
		return "views/diseniadorFrom";
	}

	/*
	 * @PostMapping("/save") public String GuardarVentas(Ventas ventas,BindingResult
	 * result) { if(result.hasErrors()) { for (ObjectError error:
	 * result.getAllErrors()){ System.out.println("Ocurrio un error: "+
	 * error.getDefaultMessage()); } return "views/ventasForm"; }
	 * System.out.println("ventas= "+ventas); Factura fact=new Factura();
	 * 
	 * fact.setIdfactura(0000000002); ventas.setFactura(fact);
	 * serviceventas.guardar(ventas);
	 * 
	 * 
	 * 
	 * 
	 * return "redirect:/panel/ventas"; }
	 */
}
