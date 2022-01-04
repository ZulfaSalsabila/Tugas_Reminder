/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latihan.TugasJava;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ROG
 */
@Controller
public class DataController {
    @RequestMapping("/input")
    public String HitungDiskon(HttpServletRequest data, Model PotonganHarga){
        String masukkanNama = data.getParameter("Vegetable_Name");
        String masukkanHarga = data.getParameter("Vegetable_Price");
        String masukkanJumlah = data.getParameter("Vegetable_Quantity");
        String inputMoney = data.getParameter("var_money");
        
       
        String discount="";
        
        Double Harga = Double.valueOf(masukkanHarga);
        Double Jumlah = Double.valueOf(masukkanJumlah);
        Double iMoney = Double.valueOf(inputMoney);
        Double TotalHarga = Harga * Jumlah;
        Double getTotal = null;
        Double totalDiskon = null;
        
        if (TotalHarga < 16000){
            getTotal = TotalHarga - (0 * TotalHarga / 100);
            discount="0%"; 
            totalDiskon = 0 * TotalHarga / 100;
            
        }
        else if (TotalHarga >= 16000 && TotalHarga < 25000){
            getTotal = TotalHarga - (10 * TotalHarga / 100);
            discount="10%";
            totalDiskon = 10 * TotalHarga / 100;
        } 
        else if (TotalHarga >= 25000){
            getTotal = TotalHarga - (15 * TotalHarga / 100);
            discount="15%";
            totalDiskon = 15 * TotalHarga / 100;
        }
        
        Double kembali = iMoney - getTotal;
        
        PotonganHarga.addAttribute("name",masukkanNama);
        PotonganHarga.addAttribute("price",masukkanHarga);
        PotonganHarga.addAttribute("quantity",masukkanJumlah);
        PotonganHarga.addAttribute("totalPrice",getTotal);
        PotonganHarga.addAttribute("PriceTotal",TotalHarga);
        PotonganHarga.addAttribute("discPrice",totalDiskon);
        PotonganHarga.addAttribute("discount",discount);
        PotonganHarga.addAttribute("money",inputMoney);
        PotonganHarga.addAttribute("return",kembali);
        
        
        return "tampilanPage";
    }
    
}
