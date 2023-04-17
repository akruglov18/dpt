
package webservice.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetField_QNAME = new QName("http://Server/", "getField");
    private final static QName _GetFieldResponse_QNAME = new QName("http://Server/", "getFieldResponse");
    private final static QName _MakeTurn_QNAME = new QName("http://Server/", "makeTurn");
    private final static QName _MakeTurnResponse_QNAME = new QName("http://Server/", "makeTurnResponse");
    private final static QName _Register_QNAME = new QName("http://Server/", "register");
    private final static QName _RegisterResponse_QNAME = new QName("http://Server/", "registerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetField }
     * 
     */
    public GetField createGetField() {
        return new GetField();
    }

    /**
     * Create an instance of {@link GetFieldResponse }
     * 
     */
    public GetFieldResponse createGetFieldResponse() {
        return new GetFieldResponse();
    }

    /**
     * Create an instance of {@link MakeTurn }
     * 
     */
    public MakeTurn createMakeTurn() {
        return new MakeTurn();
    }

    /**
     * Create an instance of {@link MakeTurnResponse }
     * 
     */
    public MakeTurnResponse createMakeTurnResponse() {
        return new MakeTurnResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link Turn }
     * 
     */
    public Turn createTurn() {
        return new Turn();
    }

    /**
     * Create an instance of {@link Edge }
     * 
     */
    public Edge createEdge() {
        return new Edge();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetField }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetField }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getField")
    public JAXBElement<GetField> createGetField(GetField value) {
        return new JAXBElement<GetField>(_GetField_QNAME, GetField.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFieldResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFieldResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getFieldResponse")
    public JAXBElement<GetFieldResponse> createGetFieldResponse(GetFieldResponse value) {
        return new JAXBElement<GetFieldResponse>(_GetFieldResponse_QNAME, GetFieldResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeTurn }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MakeTurn }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "makeTurn")
    public JAXBElement<MakeTurn> createMakeTurn(MakeTurn value) {
        return new JAXBElement<MakeTurn>(_MakeTurn_QNAME, MakeTurn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeTurnResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MakeTurnResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "makeTurnResponse")
    public JAXBElement<MakeTurnResponse> createMakeTurnResponse(MakeTurnResponse value) {
        return new JAXBElement<MakeTurnResponse>(_MakeTurnResponse_QNAME, MakeTurnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Register }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

}
