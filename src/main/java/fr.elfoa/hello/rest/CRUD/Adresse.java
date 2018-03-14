package fr.elfoa.hello.rest.CRUD;


import javax.ws.rs.*;
import java.util.ArrayList;

@Path("adresse")
public class Adresse {

    private static ArrayList<Adresse> adresses = new ArrayList<>();
    private String cp;
    private int num;
    private String pays;
    private String voie;
    private String voietype;

    public Adresse() {
    }

    private Adresse(String cp, int num, String pays, String voie, String voietype) {
        this.cp = cp;
        this.num = num;
        this.pays = pays;
        this.voie = voie;
        this.voietype = voietype;
    }

    @POST
    @Path("{cp}/{num}/{pays}/{voie}/{voietype}")
    public void addAdress(@PathParam("cp") String cp,
                          @PathParam("num")int num, @PathParam("pays") String pays,
                          @PathParam("voie") String voie,
                          @PathParam("voietype") String voietype){
        System.out.println("------------------ ADD -------------------");
        adresses.add(new Adresse(cp, num, pays ,voie, voietype));
    }

    @GET
    @Path("num/{num}")
    public int getNum(@PathParam("num") int id){
        return adresses.get(id).num;
    }

    @GET
    @Path("cp/{id}")
    public String getCp(@PathParam("id") int id ) {
        return adresses.get(id).cp;
    }
    @GET
    @Path("pays/{id}")
    public String getPays(@PathParam("id") int id ) {
        return adresses.get(id).pays;
    }
    @GET
    @Path("voie/{id}")
    public String getVoie(@PathParam("id") int id ) {
        return adresses.get(id).voie;
    }
    @GET
    @Path("voietype/{id}")
    public String getVoieType(@PathParam("id") int id ) {
        return adresses.get(id).voietype;
    }


    @GET
    public int getNumberAdresse(){
        return adresses.size();
    }

    @PUT
    @Path("newCp/{cp}/{id}")
    public void setCp(@PathParam("cp") String cp, @PathParam("id") int id) {
        adresses.get(id).cp = cp;
    }

    @PUT
    @Path("newNum/{num}/{id}")
    public void setNum(@PathParam("num") int num,
                       @PathParam("id") int id) {
        adresses.get(id).num = num;
    }

    @PUT
    @Path("newPays/{pays}/{id}")
    public void setPays(@PathParam("pays") String pays,
                        @PathParam("id") int id) {
        adresses.get(id).pays = pays;
    }

    @PUT
    @Path("newVoie/{voie}/{id}")
    public void setVoie(@PathParam("voie") String voie,
                        @PathParam("id") int id) {
        adresses.get(id).voie = voie;
    }

    @PUT
    @Path("newVoieType/{voietype}/{id}")
    public void setVoietype(@PathParam("voietype") String voietype,
                            @PathParam("id") int id) {
        adresses.get(id).voietype = voietype;
    }

    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") int id){
        adresses.remove(id);
    }

}
