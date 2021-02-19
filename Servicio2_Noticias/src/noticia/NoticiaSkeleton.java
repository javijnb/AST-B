/**
 * NoticiaSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package noticia;

/**
 *  NoticiaSkeleton java skeleton for the axisService
 */
public class NoticiaSkeleton {
    /**
     * Auto generated method signature
     *
     * @param getTitular
     * @return getTitularResponse
     */

    private static String titular = "Titular por defecto";
    private static String url = "URL por defecto";
    private static String descripcion = "Descripcion por defecto";



    public noticia.GetTitularResponse getTitular(noticia.GetTitular getTitular) {
        //TODO : fill this with the necessary business logic
        //throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getTitular");
        noticia.GetTitularResponse titularResp = new noticia.GetTitularResponse();
        titularResp.set_return(NoticiaSkeleton.titular);
        return titularResp;
    }

    /**
     * Auto generated method signature
     *
     * @param setTitular
     * @return
     */
    public void setTitular(noticia.SetTitular setTitular) {
        //TODO : fill this with the necessary business logic
        titular = setTitular.getTitular();
    }

    /**
     * Auto generated method signature
     *
     * @param setDescripcion
     * @return
     */
    public void setDescripcion(noticia.SetDescripcion setDescripcion) {
        //TODO : fill this with the necessary business logic
        descripcion = setDescripcion.getDescripcion();
    }

    /**
     * Auto generated method signature
     *
     * @param getDescripcion
     * @return getDescripcionResponse
     */
    public noticia.GetDescripcionResponse getDescripcion(noticia.GetDescripcion getDescripcion) {
        //TODO : fill this with the necessary business logic
        //throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getDescripcion");
        noticia.GetDescripcionResponse descripcionResp = new noticia.GetDescripcionResponse();
        descripcionResp.set_return(NoticiaSkeleton.descripcion);
        return descripcionResp;
    }

    /**
     * Auto generated method signature
     *
     * @param getUrl
     * @return getUrlResponse
     */
    public noticia.GetUrlResponse getUrl(noticia.GetUrl getUrl) {
        //TODO : fill this with the necessary business logic
        //throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getUrl");
        noticia.GetUrlResponse urlResp = new noticia.GetUrlResponse();
        urlResp.set_return(NoticiaSkeleton.url);
        return urlResp;
    }

    /**
     * Auto generated method signature
     *
     * @param setUrl
     * @return
     */
    public void setUrl(noticia.SetUrl setUrl) {
        //TODO : fill this with the necessary business logic
        url = setUrl.getUrl();
    }
}
