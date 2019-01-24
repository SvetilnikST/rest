/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package rest;

import dao.city.CityDAO;
import dao.city.TblCityEntity;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Stateless
@Path("city")
public class CityREST implements Serializable {

    @EJB
    private CityDAO cityDAO;

    @GET
    @Produces({"application/xml","application/json"})
    public List<TblCityEntity> getAll(
            @QueryParam("size") int size,
            @QueryParam("from") int from
    ) {
        List<TblCityEntity> ret = cityDAO.getAll(from, size);

        return ret;
    }


//    @GET
//    @Path("aa/{id}")
//    @Produces({"application/json"})
//    public String find2(@PathParam("id") Integer id) {
//        return hello.get(id);
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({"application/json"})
//    public String find(@PathParam("id") Integer id) {
//        return hello.get(id);
//    }
//
//
//    @PUT
//    @Path("{id}")
//    @Consumes({"application/json"})
//    public void edit(@PathParam("id") int id, String entity) {
//
//        hello.set(id,entity);
//        int a = 0;
//    }
//
//    @POST
//    @Consumes({"application/json"})
//    public void edit(String entity) {
//        hello.add(entity);
//        int a = 0;
//    }

//    @POST
//    @Path("{id}")
//    @Produces({"application/json"})
//    public String find3(@PathParam("id") Integer id) {
//        return "HAAAAAAAA-HAAAAA-HAAAA";
//    }

//    @GET
//    @Override
//    @Produces({"application/xml", "application/json"})
//    public List<Movie> getAll() {
//        return super.getAll();
//    }


//    @POST
//    @Override
//    @Consumes({"application/xml", "application/json"})
//    public void create(Movie entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    public void edit(@PathParam("id") Integer id) {
//        super.edit(id);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Integer id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public Movie find(@PathParam("id") Integer id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({"application/xml", "application/json"})
//    public List<Movie> getAll() {
//        return super.getAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Movie> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces("text/plain")
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
//
}
