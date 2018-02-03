package fr.elfoa.hello.jpa.crm;

import fr.elfoa.hello.jpa.crm.Client_Adresse;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.2.v20151217-rNA", date="2018-02-03T16:37:06")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Date> date;
    public static volatile SingularAttribute<Commande, Client_Adresse> clientAdresse;
    public static volatile SingularAttribute<Commande, Integer> id;

}