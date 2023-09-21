/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.modelos;

import java.sql.Date;

/**
 *
 * @author FONSYS
 */
public class Producido {
     private String numeroveh;
     private String numeropla;
     private String tercero;
     private String conductor;
     private String grupo;
     private String nombregrupo;
     private Date fechacier ;
     private float  vlr_producido;
     private float  pagoconduc;
     private float  timb_cajau;     
     private float  timbradas;     
     private String detalle;
     private String documenref;
     private int viajes;
     private float promedgrup;

    public Producido() {
    }

    public Producido(String numeroveh, String numeropla, String tercero, String conductor, String grupo, String nombregrupo, Date fechacier, 
                     float vlr_producido, float pagoconduc, float timb_cajau, float timbradas, String detalle, String documenref, int viajes, float promedgrup) {
        this.numeroveh = numeroveh;
        this.numeropla = numeropla;
        this.tercero = tercero;
        this.conductor = conductor;
        this.grupo = grupo;
        this.nombregrupo = nombregrupo;
        this.fechacier = fechacier;
        this.vlr_producido = vlr_producido;
        this.pagoconduc = pagoconduc;
        this.timb_cajau = timb_cajau;
        this.timbradas = timbradas;
        this.detalle = detalle;
        this.documenref = documenref;
        this.viajes = viajes;
        this.promedgrup = promedgrup;
    }

    public String getNumeroveh() {
        return numeroveh;
    }

    public void setNumeroveh(String numeroveh) {
        this.numeroveh = numeroveh;
    }

    public String getNumeropla() {
        return numeropla;
    }

    public void setNumeropla(String numeropla) {
        this.numeropla = numeropla;
    }

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public Date getFechacier() {
        return fechacier;
    }

    public void setFechacier(Date fechacier) {
        this.fechacier = fechacier;
    }

    public float getVlr_producido() {
        return vlr_producido;
    }

    public void setVlr_producido(float vlr_producido) {
        this.vlr_producido = vlr_producido;
    }

    public float getPagoconduc() {
        return pagoconduc;
    }

    public void setPagoconduc(float pagoconduc) {
        this.pagoconduc = pagoconduc;
    }

    public float getTimb_cajau() {
        return timb_cajau;
    }

    public void setTimb_cajau(float timb_cajau) {
        this.timb_cajau = timb_cajau;
    }

    public float getTimbradas() {
        return timbradas;
    }

    public void setTimbradas(float timbradas) {
        this.timbradas = timbradas;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDocumenref() {
        return documenref;
    }

    public void setDocumenref(String documenref) {
        this.documenref = documenref;
    }

    public int getViajes() {
        return viajes;
    }

    public void setViajes(int viajes) {
        this.viajes = viajes;
    }

    public float getPromedgrup() {
        return promedgrup;
    }

    public void setPromedgrup(float promedgrup) {
        this.promedgrup = promedgrup;
    }
  
}
