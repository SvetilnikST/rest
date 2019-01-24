package rest;

import dao.city.TblCityEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@RequestScoped
@ManagedBean(name = "clientBean")
public class ClientHttp {
    Client client;
    WebTarget target;

    private List<TblCityEntity> tblCityEntities;

    @Inject
    HttpServletRequest httpServletRequest;

    @PostConstruct
    public void init() {
        client = ClientBuilder.newClient();
        target = client.target(
                "http://" + httpServletRequest.getLocalName() + ":" +
                        httpServletRequest.getLocalPort() + "/" +
                        httpServletRequest.getContextPath()
                        + "/webresources/city/"
        );

    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    //забор json из рест сервера
    private TblCityEntity[] getCitys() {
        return target
                .request(MediaType.APPLICATION_XML)
                .get(TblCityEntity[].class);
    }


    public List<TblCityEntity> getTblCityEntities() {
        List<TblCityEntity> ret = Arrays.asList(getCitys());
        return ret;
    }

//    public void setTblCityEntities(List<TblCityEntity> tblCityEntities) {
//        this.tblCityEntities = tblCityEntities;
//    }
}
