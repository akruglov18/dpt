
package webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GameServer", targetNamespace = "http://Server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GameServer {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getField", targetNamespace = "http://Server/", className = "webservice.service.GetField")
    @ResponseWrapper(localName = "getFieldResponse", targetNamespace = "http://Server/", className = "webservice.service.GetFieldResponse")
    @Action(input = "http://Server/GameServer/getFieldRequest", output = "http://Server/GameServer/getFieldResponse")
    public String getField(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "register", targetNamespace = "http://Server/", className = "webservice.service.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://Server/", className = "webservice.service.RegisterResponse")
    @Action(input = "http://Server/GameServer/registerRequest", output = "http://Server/GameServer/registerResponse")
    public String register();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "makeTurn", targetNamespace = "http://Server/", className = "webservice.service.MakeTurn")
    @ResponseWrapper(localName = "makeTurnResponse", targetNamespace = "http://Server/", className = "webservice.service.MakeTurnResponse")
    @Action(input = "http://Server/GameServer/makeTurnRequest", output = "http://Server/GameServer/makeTurnResponse")
    public void makeTurn(
        @WebParam(name = "arg0", targetNamespace = "")
        Turn arg0);

}
