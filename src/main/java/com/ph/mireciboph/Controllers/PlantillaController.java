package com.ph.mireciboph.Controllers;

import com.ph.mireciboph.Entity.DTO.ReciboInfoDTO;
import com.ph.mireciboph.services.PrediosService;
import com.ph.mireciboph.services.RecibosService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PlantillaController {

    private final PrediosService prediosService;

    @GetMapping("/recibo")
    public String mostrarRecibo(@RequestParam("ref") String referencia, Model model) {
        ReciboInfoDTO dto = prediosService.obtenerDatosPorReferencia(referencia);
        Map<String, Object> calculos = prediosService.procesarDatosRecibo(dto);

        // ===== DATOS CALCULADOS =====
        BigDecimal total = (BigDecimal) calculos.get("total");
        BigDecimal prontoPago = (BigDecimal) calculos.get("pagoPronto");
        String fechaFormateada = (String) calculos.get("fecha");
        String fechaLimite = (String) calculos.get("fechaLimite");

        // ===== RESIDENTE =====
        model.addAttribute("referenciaResidente", dto.getReferencia());
        model.addAttribute("fechaResidente", fechaFormateada);
        model.addAttribute("nombreResidente", dto.getNombrePersona());
        model.addAttribute("torreResidente", "1");  // Fijo o dinámico si tienes el dato
        model.addAttribute("aptoResidente", "201");
        model.addAttribute("reciboResidente", "8377");
        model.addAttribute("cuentaComultrasanResidente", "050570000784");
        model.addAttribute("cuentaFinandinaResidente", "904000534");
        model.addAttribute("cuentaBancolombiaResidente", "81489459072");

        model.addAttribute("anterior1Residente",  dto.getCampo03());
        model.addAttribute("cargo1Residente", dto.getCampo04());
        model.addAttribute("subtotal1Residente", dto.getCampo03().add(dto.getCampo04()));
        model.addAttribute("anterior2Residente", dto.getCampo05());
        model.addAttribute("cargo2Residente", dto.getCampo06());
        model.addAttribute("subtotal2Residente", dto.getCampo05().add(dto.getCampo06()));
        model.addAttribute("anterior3Residente", dto.getCampo07());
        model.addAttribute("cargo3Residente", dto.getCampo08());
        model.addAttribute("subtotal3Residente", dto.getCampo07().add(dto.getCampo08()));
        model.addAttribute("anterior4Residente", dto.getCampo09());
        model.addAttribute("cargo4Residente", dto.getCampo10());
        model.addAttribute("subtotal4Residente", dto.getCampo09().add(dto.getCampo10()));

        model.addAttribute("totalResidente", total);
        model.addAttribute("descuentoResidente", "10000");
        model.addAttribute("fechaLimiteResidente", fechaLimite);
        model.addAttribute("pagoProntoResidente", prontoPago);

        // ===== BANCO =====
        model.addAttribute("fechaBanco", fechaFormateada);
        model.addAttribute("referenciaBanco", dto.getReferencia());
        model.addAttribute("nomPersonaBanco", dto.getNombrePersona());
        model.addAttribute("nomPredioBanco", dto.getNombrePredio());
        model.addAttribute("valor02Banco", dto.getCampo02());

        model.addAttribute("cuentaComultrasanBanco", "050570000784");
        model.addAttribute("cuentaFinandinaBanco", "904000534");
        model.addAttribute("cuentaBancolombiaBanco", "81489459072");

        model.addAttribute("anterior1Banco", dto.getCampo03());
        model.addAttribute("cargo1Banco", dto.getCampo04());
        model.addAttribute("subtotal1Banco", dto.getCampo03().add(dto.getCampo04()));
        model.addAttribute("concepto01Banco", dto.getConcepto01());
        model.addAttribute("anterior2Banco", dto.getCampo05());
        model.addAttribute("cargo2Banco",dto.getCampo06());
        model.addAttribute("subtotal2Banco", dto.getCampo05().add(dto.getCampo06()));
        model.addAttribute("anterior3Banco", dto.getCampo07());
        model.addAttribute("cargo3Banco", dto.getCampo08());
        model.addAttribute("subtotal3Banco", dto.getCampo07().add(dto.getCampo08()));
        model.addAttribute("anterior4Banco", dto.getCampo09());
        model.addAttribute("cargo4Banco", dto.getCampo10());
        model.addAttribute("subtotal4Banco", dto.getCampo09().add(dto.getCampo10()));

        model.addAttribute("totalBanco", total);
        model.addAttribute("descuentoBanco", "10000");
        model.addAttribute("fechaLimiteBanco", fechaLimite);
        model.addAttribute("pagoProntoBanco", prontoPago);

        return "plantilla";
    }

}
