package com.ph.mireciboph.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlantillaController {

    @GetMapping("/plantilla")
    public String mostrarPlantilla(Model model) {
        // RESIDENTE
        model.addAttribute("referenciaResidente", "1201");
        model.addAttribute("fechaResidente", "Junio 1 de 2025");
        model.addAttribute("nombreResidente", "Tarazona De Torres Isidora");
        model.addAttribute("torreResidente", "1");
        model.addAttribute("aptoResidente", "201");
        model.addAttribute("reciboResidente", "8377");
        model.addAttribute("cuentaComultrasanResidente", "050570000784");
        model.addAttribute("cuentaFinandinaResidente", "904000534");
        model.addAttribute("cuentaBancolombiaResidente", "81489459072");

        model.addAttribute("anterior1Residente", "");
        model.addAttribute("cargo1Residente", "237.000");
        model.addAttribute("subtotal1Residente", "237.000");
        model.addAttribute("anterior2Residente", "");
        model.addAttribute("cargo2Residente", "");
        model.addAttribute("subtotal2Residente", "");
        model.addAttribute("anterior3Residente", "");
        model.addAttribute("cargo3Residente", "");
        model.addAttribute("subtotal3Residente", "");
        model.addAttribute("anterior4Residente", "");
        model.addAttribute("cargo4Residente", "");
        model.addAttribute("subtotal4Residente", "");

        model.addAttribute("totalResidente", "237.000");
        model.addAttribute("descuentoResidente", "10.000");
        model.addAttribute("fechaLimiteResidente", "21 de Junio");
        model.addAttribute("pagoProntoResidente", "227.000");

        // BANCO
        model.addAttribute("fechaBanco", "Fecha");
        model.addAttribute("referenciaBanco", "Valor 01");
        model.addAttribute("nomPersonaBanco", "nomPersona");
        model.addAttribute("nomPredioBanco", "nomPredio");
        model.addAttribute("valor02Banco", "Valor 02");
        model.addAttribute("cuentaComultrasanBanco", "050570000784");
        model.addAttribute("cuentaFinandinaBanco", "904000534");
        model.addAttribute("cuentaBancolombiaBanco", "81489459072");

        model.addAttribute("anterior1Banco", "Valor 03");
        model.addAttribute("cargo1Banco", "Valor 04");
        model.addAttribute("subtotal1Banco", "237.000");
        model.addAttribute("concepto01Banco", "Concepto 01");
        model.addAttribute("anterior2Banco", "Valor 05");
        model.addAttribute("cargo2Banco", "0");
        model.addAttribute("subtotal2Banco", "0");
        model.addAttribute("anterior3Banco", "Valor 06");
        model.addAttribute("cargo3Banco", "Valor 07");
        model.addAttribute("subtotal3Banco", "0");
        model.addAttribute("anterior4Banco", "Valor 08");
        model.addAttribute("cargo4Banco", "Valor 09");
        model.addAttribute("subtotal4Banco", "0");

        model.addAttribute("totalBanco", "237.000");
        model.addAttribute("descuentoBanco", "10.000");
        model.addAttribute("fechaLimiteBanco", "21 de Junio");
        model.addAttribute("pagoProntoBanco", "227.000");

        return "plantilla";
    }
}
