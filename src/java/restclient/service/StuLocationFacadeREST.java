/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import restclient.LocationCount;
import restclient.StuLocation;
import restclient.StuProfile;

/**
 *
 * @author Dangerlal
 */
@Stateless
@Path("restclient.stulocation")
public class StuLocationFacadeREST extends AbstractFacade<StuLocation> {

    @PersistenceContext(unitName = "FIT5046Assign1PU")
    private EntityManager em;

    public StuLocationFacadeREST() {
        super(StuLocation.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StuLocation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StuLocation entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public StuLocation find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuLocation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuLocation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //Get location by locLat
    @GET
    @Path("findByLocLat/{locLat}")
    @Produces({"application/json"})
    public List<StuLocation> findByLocLat(@PathParam("locLat") Double locLat){
        Query query = em.createNamedQuery("StuLocation.findByLocLat");
        query.setParameter("locLat", locLat);
        return query.getResultList();
    }
    
    //Get location by locLon
    @GET
    @Path("findByLocLon/{locLon}")
    @Produces({"application/json"})
    public List<StuLocation> findByLocLon(@PathParam("locLon") Double locLon){
        Query query = em.createNamedQuery("StuLocation.findByLocLon");
        query.setParameter("locLon", locLon);
        return query.getResultList();
    }
    
    //Get location by locDate
    @GET
    @Path("findByLocDate/{locDate}")
    @Produces({"application/json"})
    public List<StuLocation> findBylocDate(@PathParam("locDate") String locDate) throws ParseException{
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date lDate = df.parse(locDate);
        
        Query query = em.createNamedQuery("StuLocation.findByLocDate");
        query.setParameter("locDate", lDate);
        return query.getResultList();
    }
    
    //Get location by locTime
    @GET
    @Path("findByLocTime/{locTime}")
    @Produces({"application/json"})
    public List<StuLocation> findBylocTime(@PathParam("locTime") String locTime)throws ParseException{
        
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date lTime = df.parse(locTime);
        
        Query query = em.createNamedQuery("StuLocation.findByLocTime");
        query.setParameter("locTime", lTime);
        return query.getResultList();
    }
    
    //Get location by locName
    @GET
    @Path("findByLocName/{locName}")
    @Produces({"application/json"})
    public List<StuLocation> findBylocName(@PathParam("locName") String locName){
        Query query = em.createNamedQuery("StuLocation.findByLocName");
        query.setParameter("locName", locName);
        return query.getResultList();
    }
        
    //Task 2)- b)3
    //Get location profile by Gender, Favorite Movie and Location
    @GET
    @Path("findByGenderFMovieANDLocation/{stuGender}/{stuFavMovie}/{locName}")
    @Produces({"application/json"})
    public List<StuLocation> findByGenderFMovieANDLocation(@PathParam("stuGender") String stuGender, 
            @PathParam("stuFavMovie") String stuFavMovie, @PathParam("locName") String locName) throws ParseException{
        
        TypedQuery<StuLocation> query = em.createQuery("SELECT l FROM StuLocation l WHERE l.stuId.stuGender = :stuGender AND l.stuId.stuFavMovie = :stuFavMovie AND l.locName = :locName " ,StuLocation.class);
        query.setParameter("stuGender", stuGender);
        query.setParameter("stuFavMovie", stuFavMovie);
        query.setParameter("locName", locName);
        return query.getResultList();
    }
   
    //Task 2)- b)4
    //Get student profile by location name and favourite sport
    @GET
    @Path("findByLocNameANDFavSport/{locName}/{stuFavSport}")
    @Produces({"application/json"})
    public List<StuProfile> findByLocNameANDFavSport( @PathParam("locName") String locName, @PathParam("stuFavSport") String stuFavSport) throws ParseException{
        
        Query query = em.createNamedQuery("StuLocation.findByLocNameANDFavSport");
        query.setParameter("locName", locName);
        query.setParameter("stuFavSport", stuFavSport);
        List<StuProfile> l = query.getResultList();
        return l;
    }
    
    //Task 3)- a)
    //Get location visited by student and it's frequency withing given dates
    @GET
    @Path("listByStDateEnDateANDStuId/{stDate}/{enDate}/{stuId}")
    @Produces({"application/json"})
    public List<LocationCount> listByStDateEnDateANDStuId( @PathParam("stDate") String stDate, @PathParam("enDate") String enDate, @PathParam("stuId") String stuId) throws ParseException, JSONException{
        
        //Convert string to date
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Date sDate = df.parse(stDate);
        Date eDate = df.parse(enDate);
        
        //Get location visited with count for given student id
        TypedQuery<Object[]> query = em.createQuery("SELECT s.locName, count(s) FROM StuLocation s WHERE s.locDate >= :stDate AND s.locDate <= :enDate AND s.stuId.stuId = :stuId GROUP BY  s.locName", Object[].class);
        query.setParameter("stDate", sDate);
        query.setParameter("enDate", eDate);
        query.setParameter("stuId", stuId);
        
        //Convert object array to "custom" class LocationCount list
        List<LocationCount> resultList = new ArrayList<>();
        List<Object[]> locList = query.getResultList();
        
        for(int i=0; i<locList.size(); i++) {
            //Extract attributes from object array
            Object[] obj = locList.get(i);
            String location = (String) obj[0];
            Long count = (Long) obj[1];
            LocationCount lobj = new LocationCount(location, count);
            resultList.add(lobj);
        }
        
        return resultList;
    }
    
    //Task 3)- b)
    //Get nearby students on the basis of longitude and latitude
    @GET
    @Path("listNearByStudents/{stuId}/{locLat}/{locLon}")
    @Produces({"application/json"})
    public String listNearByStudents( @PathParam("stuId") String stuId, @PathParam("locLat") String locLat, @PathParam("locLon") String locLon) throws JSONException {
        
        //Get all distinct student IDs
        TypedQuery<String> queryDistStuId = em.createQuery("SELECT DISTINCT s.stuId FROM StuLocation s WHERE s.stuId.stuId != :stuId ", String.class);
        queryDistStuId.setParameter("stuId", stuId);
        List<String> stuIdList = queryDistStuId.getResultList();
        
        HashMap<Double,StuLocation> h = new HashMap<Double,StuLocation>();
        for(int i=0; i<stuIdList.size(); i++){
            //Get students on the basis of their last recorded time
            TypedQuery<StuLocation> query = em.createQuery("SELECT s FROM StuLocation s WHERE s.stuId = :stuId ORDER BY s.locDate DESC", StuLocation.class);
            query.setParameter("stuId", stuIdList.get(i));
            
            //Get top 1 result
            StuLocation s = query.setMaxResults(1).getSingleResult();
            
            //Calculate student disatnce
            Double distance = Distance(s.getLocLat(),s.getLocLon(), Double.parseDouble(locLat),Double.parseDouble(locLon));
            h.put(distance,s);
            
        }
        
        //Sort hash map
        TreeMap<Double,StuLocation> treeMap = new TreeMap<Double,StuLocation>(h);
        
        JSONArray friendArray = new JSONArray();
        for(Map.Entry<Double,StuLocation> entry : treeMap.entrySet()) {
            //Retreive key and values from tree map
            Double key = entry.getKey();
            StuLocation value = entry.getValue();
            
            JSONObject retVal = new JSONObject();
            //Prepare friend entry in result
            retVal.put("stuFname", value.getStuId().getStuFname());
            retVal.put("stuLname", value.getStuId().getStuLname());
            retVal.put("locName", value.getLocName());
            retVal.put("locLat", value.getLocLat());
            retVal.put("locLon", value.getLocLon());
            retVal.put("Distance", new DecimalFormat("#0.00").format(key));
            friendArray.put(retVal);            
        }
        return friendArray.toString();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public double Distance(double lat1, double lon1, double lat2, double lon2){
        double earthRadius = 6371; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }
}
