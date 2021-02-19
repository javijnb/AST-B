/**
 * NoticiaMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package noticia;


/**
 *  NoticiaMessageReceiverInOut message receiver
 */
public class NoticiaMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {
    public void invokeBusinessLogic(
        org.apache.axis2.context.MessageContext msgContext,
        org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault {
        try {
            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            NoticiaSkeleton skel = (NoticiaSkeleton) obj;

            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;

            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
                                                                      .getAxisOperation();

            if (op == null) {
                throw new org.apache.axis2.AxisFault(
                    "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;

            if ((op.getName() != null) &&
                    ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                            op.getName().getLocalPart())) != null)) {
                if ("getTitular".equals(methodName)) {
                    noticia.GetTitularResponse getTitularResponse22 = null;
                    noticia.GetTitular wrappedParam = (noticia.GetTitular) fromOM(msgContext.getEnvelope()
                                                                                            .getBody()
                                                                                            .getFirstElement(),
                            noticia.GetTitular.class);

                    getTitularResponse22 = skel.getTitular(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getTitularResponse22, false,
                            new javax.xml.namespace.QName("http://Noticia",
                                "getTitularResponse"));
                } else
                 if ("getDescripcion".equals(methodName)) {
                    noticia.GetDescripcionResponse getDescripcionResponse24 = null;
                    noticia.GetDescripcion wrappedParam = (noticia.GetDescripcion) fromOM(msgContext.getEnvelope()
                                                                                                    .getBody()
                                                                                                    .getFirstElement(),
                            noticia.GetDescripcion.class);

                    getDescripcionResponse24 = skel.getDescripcion(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getDescripcionResponse24, false,
                            new javax.xml.namespace.QName("http://Noticia",
                                "getDescripcionResponse"));
                } else
                 if ("getUrl".equals(methodName)) {
                    noticia.GetUrlResponse getUrlResponse26 = null;
                    noticia.GetUrl wrappedParam = (noticia.GetUrl) fromOM(msgContext.getEnvelope()
                                                                                    .getBody()
                                                                                    .getFirstElement(),
                            noticia.GetUrl.class);

                    getUrlResponse26 = skel.getUrl(wrappedParam);

                    envelope = toEnvelope(getSOAPFactory(msgContext),
                            getUrlResponse26, false,
                            new javax.xml.namespace.QName("http://Noticia",
                                "getUrlResponse"));
                } else {
                    throw new java.lang.RuntimeException("method not found");
                }

                newMsgContext.setEnvelope(envelope);
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(noticia.GetTitular param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.GetTitular.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        noticia.GetTitularResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.GetTitularResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(noticia.SetTitular param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.SetTitular.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(noticia.SetDescripcion param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.SetDescripcion.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(noticia.GetDescripcion param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.GetDescripcion.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(
        noticia.GetDescripcionResponse param, boolean optimizeContent)
        throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.GetDescripcionResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(noticia.GetUrl param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.GetUrl.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(noticia.GetUrlResponse param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.GetUrlResponse.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.om.OMElement toOM(noticia.SetUrl param,
        boolean optimizeContent) throws org.apache.axis2.AxisFault {
        try {
            return param.getOMElement(noticia.SetUrl.MY_QNAME,
                org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        noticia.GetTitularResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    noticia.GetTitularResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private noticia.GetTitularResponse wrapgetTitular() {
        noticia.GetTitularResponse wrappedElement = new noticia.GetTitularResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        noticia.GetDescripcionResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    noticia.GetDescripcionResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private noticia.GetDescripcionResponse wrapgetDescripcion() {
        noticia.GetDescripcionResponse wrappedElement = new noticia.GetDescripcionResponse();

        return wrappedElement;
    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory,
        noticia.GetUrlResponse param, boolean optimizeContent,
        javax.xml.namespace.QName elementQName)
        throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody()
                         .addChild(param.getOMElement(
                    noticia.GetUrlResponse.MY_QNAME, factory));

            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private noticia.GetUrlResponse wrapgetUrl() {
        noticia.GetUrlResponse wrappedElement = new noticia.GetUrlResponse();

        return wrappedElement;
    }

    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
        org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
        java.lang.Class type) throws org.apache.axis2.AxisFault {
        try {
            if (noticia.GetDescripcion.class.equals(type)) {
                return noticia.GetDescripcion.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.GetDescripcionResponse.class.equals(type)) {
                return noticia.GetDescripcionResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.GetTitular.class.equals(type)) {
                return noticia.GetTitular.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.GetTitularResponse.class.equals(type)) {
                return noticia.GetTitularResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.GetUrl.class.equals(type)) {
                return noticia.GetUrl.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.GetUrlResponse.class.equals(type)) {
                return noticia.GetUrlResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.SetDescripcion.class.equals(type)) {
                return noticia.SetDescripcion.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.SetTitular.class.equals(type)) {
                return noticia.SetTitular.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (noticia.SetUrl.class.equals(type)) {
                return noticia.SetUrl.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

        return null;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();

        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }
} //end of class
