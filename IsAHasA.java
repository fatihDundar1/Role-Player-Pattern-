package oop1;

abstract class CALISAN{
	
int id;
String AdSoyad;
double maas;
String pozisyon;
	
 abstract double hesapla(double tlKM,double tlTON);
 abstract double HESAPLA(double yuzdeGUNDUZ,double yuzdeGECE);

 void getParam(String aracCinsi,int miktar ,int KM) {}
 void getParam(String sinifi,String vardiya ,int calismaSuresi) {}
 
} 

class TasimaTuru extends CALISAN{
	
	int miktar=30;
	String aracCinsi;
	int KM=23;  
	
	void getParam(String aracCinsi,int miktar,int KM) {
		this.aracCinsi=aracCinsi;
		this.miktar=miktar;
		this.KM=KM;
	}
	
	double hesapla(double tlKM,double tlTON) {
		
		if(aracCinsi=="KAMYON") {return (KM*tlKM)+miktar*tlTON;} 
		
		if(aracCinsi=="TIR") {return (KM*tlKM)+miktar*tlTON;}
		
		else return 0.0;
		
	 }
	
	double HESAPLA(double yuzdeGUNDUZ,double yuzdeGECE) {return 0.0;}
}


class EhliyetTuru extends CALISAN{
	
   String sinifi;
   String aracPlaka;
   String vardiya;
   int calismaSuresi;
   int asgariUcret=5500;	
   
   
   void getParam(String sinifi,String vardiya,int calismaSuresi) {
	   
	   this.sinifi=sinifi;
	   this.vardiya=vardiya;
	   this.calismaSuresi=calismaSuresi; 
   }
   
   
   
   double HESAPLA( double yuzdeGUNDUZ,double yuzdeGECE) {


  if(sýnýfý=="kamyon") {	
	  
	   if(vardiya=="GUNDUZ" && calismaSuresi>12) {return (asgariUcret*yuzdeGUNDUZ)/100; }
	   
	   if(vardiya=="GUNDUZ" && calismaSuresi<12) {return asgariUcret;}
	   
	   if(vardiya=="GECE") {
		   int saatlikUcret= asgariUcret/12;
		   return ( ((saatlikUcret*yuzdeGECE)/100)*calismaSuresi+asgariUcret); }
   }
    
  else if(sýnýfý=="vincOperatoru") {
	  
	  if(vardiya=="GUNDUZ" && calismaSuresi>12) {return (asgariUcret*yuzdeGUNDUZ)/100; }
	   
	   if(vardiya=="GUNDUZ" && calismaSuresi<12) {return asgariUcret;}
	   
	   if(vardiya=="GECE") {
		   int saatlikUcret= asgariUcret/12;
		   return ( ((saatlikUcret*yuzdeGECE)/100)*calismaSuresi+asgariUcret); }
	  
	   }
   return 0;
  }
   
   
       double hesapla(double tlKM,double tlTON) {return 0;}
   
}


class Player {
	
     CALISAN rol;

}



public class IsAHasA {
	
	public static void main(String []A) {
		
Player hurda=new Player();

hurda.rol=new TasimaTuru();
hurda.rol.getParam("KAMYON", 23, 30);
System.out.println("hurda+kamyon: "+hurda.rol.hesapla(53.87,103.33)+" tl");

hurda.rol.getParam("TIR", 23, 45);
System.out.println("hurda+týr: "+hurda.rol.hesapla(62.33,111.62)+" tl");


Player islenmisMaden= new Player();

islenmisMaden.rol=new TasimaTuru();
islenmisMaden.rol.getParam("KAMYON", 23, 45);
System.out.println("islenmis maden+kamyon: "+islenmisMaden.rol.hesapla(75.50,120.20)+" tl");

islenmisMaden.rol.getParam("TIR", 23, 45);
System.out.println("islenmis maden+týr: "+islenmisMaden.rol.hesapla(82.25,150.30)+" tl");


Player kamyonSurucusu =new Player();

kamyonSurucusu.rol=new EhliyetTuru();
kamyonSurucusu.rol.getParam("kamyon", "GUNDUZ", 13);
System.out.println("kamyon Surucusu+gunduz: "+kamyonSurucusu.rol.HESAPLA(21, 25.33)+" tl");


Player vincOperatoru =new Player();

vincOperatoru.rol=new EhliyetTuru();
vincOperatoru.rol.getParam("vincOperatoru", "GECE", 8);
System.out.println("vinc operatoru+gece: "+vincOperatoru.rol.HESAPLA(19.25, 27.42)+" tl");



	}
	
}
