package dao.city;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CityDAO {

    @PersistenceContext(unitName = "counters-app")
    private EntityManager entityManager;


    public List<TblCityEntity> getAll(){
        return getAll(0,0);
    }

    public List<TblCityEntity> getAll(int from, int size){

        TypedQuery<TblCityEntity> query = entityManager.createQuery(
                "SELECT entity from TblCityEntity entity",
                TblCityEntity.class);
        if(size!=0){
            query = query
                    .setFirstResult(from)
                    .setMaxResults(size);
        }

        List<TblCityEntity> tblCityEntityList = query.getResultList();

        return tblCityEntityList;
    }
}
