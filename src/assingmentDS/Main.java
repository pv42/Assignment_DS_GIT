package assingmentDS;

import assingmentDS.enclosure.Aquarium;
import assingmentDS.enclosure.LandMammalEnclosure;
import assingmentDS.enclosure.Aviary;
import assingmentDS.person.Visiter;
import assingmentDS.person.Stuff;
import assingmentDS.animal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by pv42 on 24.04.2017.
 * Hauptklasse, enthaelt den Startcode, Verarbeitung von Kommandozeilenargumenten
 * sowie das in der Aufgabenstellung geforderte Beispiel.
 */

public class Main {
    // Startfunktion, behandelt Kommandozeilenargumente
    public static void main(String[] args) {
        System.out.println(args.length);
        if(args.length > 0) {
            if(Objects.equals(args[0], "-h")) {
                printHelp();
                return;
            } else if(Objects.equals(args[0], "-v")) {
                printVersion();
                return;
            } else if(Objects.equals(args[0], "-f")) {
                if( args.length < 2) {
                    printHelp();
                    return;
                } else {
                    Log.redirectToFile(args[1]);
                }
            } else {
                printHelp();
            }
        }
        test();
    }

    //zeigt Kommandozeilehilfe
    private static void printHelp() {
        System.out.print("Argumente:\n" +
                "   <keine Argument> führt Programm aus\n" +
                "   -h          zeigt diese Hilfe an\n" +
                "   -v          zeigt Versionsinformationen\n" +
                "   -f <datei>  leitet Ausgabe in Datei um und führt Programm aus\n");
    }

    //zeigt Version
    private static void printVersion() {
        System.out.println("Zoo Version: 1.0");
    }

    // Aufgabenstellung
    private static void test() {
        Zoo zoo = new Zoo("Zoo");
        List<Visiter> visiter = new ArrayList<>();
        // 1.
        Aquarium wahlhaibecken = new Aquarium("Wahlhaibecken");
        Aquarium kugelfischtank = new Aquarium("Kugelfischtank");
        zoo.addGehege(wahlhaibecken);
        zoo.addGehege(kugelfischtank);
        LandMammalEnclosure landgehege1 = new LandMammalEnclosure("Landgehege1");
        LandMammalEnclosure landgehege2 = new LandMammalEnclosure("Landgehege2");
        LandMammalEnclosure landgehege3 = new LandMammalEnclosure("Landgehege3");
        LandMammalEnclosure landgehege4 = new LandMammalEnclosure("Landgehege4");
        zoo.addGehege(landgehege1);
        zoo.addGehege(landgehege2);
        zoo.addGehege(landgehege3);
        zoo.addGehege(landgehege4);
        Aviary adlergehege = new Aviary("Adlergehege");
        Aviary papgeienGehege = new Aviary("Papageiengehege");
        zoo.addGehege(papgeienGehege);
        zoo.addGehege(adlergehege);
        //2. Tick Trick Track
        Papagei tick = new Papagei("Tick");
        Papagei trick = new Papagei("Trick");
        Papagei track = new Papagei("Track");
        papgeienGehege.addTier(tick);
        papgeienGehege.addTier(trick);
        papgeienGehege.addTier(track);
        //3.  Zalana, Eddard, Bran, Robb, Arya
        Zebra zalana = new Zebra("Zalana");
        Zebra eddard = new Zebra("Eddard");
        Zebra bran = new Zebra( "Bran");
        Zebra robb = new Zebra("Robb");
        Zebra arya = new Zebra("arya");
        landgehege1.addTier(eddard);
        landgehege1.addTier(robb);
        landgehege2.addTier(bran);
        landgehege2.addTier(arya);
        landgehege2.addTier(zalana);
        //4.   Tywin, Jaime, Cersei, Joffrey
        Lion tywin = new Lion("Tywin");
        Lion jaime = new Lion("Jaime");
        Lion cersei = new Lion("Cersei");
        Lion joffrey = new Lion("Joffrey");
        landgehege3.addTier(tywin);
        landgehege3.addTier(cersei);
        landgehege3.addTier(joffrey);
        landgehege3.addTier(jaime);
        //5. Lenny
        Kugelfisch kugelfisch;
        for(int i = 1; i<=10;i++) {
            kugelfisch = new Kugelfisch("Lenny" + i); //Alle Kugelfische heißen Lenny #trueStory // TODO remove
            kugelfischtank.addTier(kugelfisch);
        }
        //6. Moby Dick
        WhaleShark moby = new WhaleShark("Moby");
        WhaleShark dick = new WhaleShark("Dick");
        wahlhaibecken.addTier(moby);
        wahlhaibecken.addTier(dick);
        //7. American Dream
        Eagle american = new Eagle("American");
        Eagle dream = new Eagle("Dream");
        adlergehege.addTier(american);
        adlergehege.addTier(dream);
        //8. Ramsay Sam Daenerys
        Stuff ramsay = new Stuff("Ramsay");
        Stuff sam = new Stuff("Sam");
        Stuff daenerys = new Stuff("Daenerys");
        zoo.addStuff(ramsay);
        zoo.addStuff(sam);
        zoo.addStuff(daenerys);
        for(Animal tier:zoo.getTiere()) { // checks if the animnal is land, water or air and asign personal
            if(LandMammal.class.isInstance(tier)) tier.setStuff(sam); // bad code
            else if(WaterAnimal.class.isInstance(tier)) tier.setStuff(sam);
            else if(Bird.class.isInstance(tier)) tier.setStuff(sam);
            else System.err.print("Error"); //todo remove!
        }
        //TODO
        //9.
        Visiter catelyn = new Visiter("Catelyn");
        Visiter aerys = new Visiter("Aerys");
        Visiter bronn = new Visiter("Bronn");
        Visiter sansa = new Visiter("Sansa");
        Visiter willy = new Visiter("Willy");
        catelyn.setEnclosure(landgehege1);
        aerys.setEnclosure(adlergehege);
        bronn.setEnclosure(kugelfischtank);
        sansa.setEnclosure(wahlhaibecken);
        willy.setEnclosure(landgehege2);
        visiter.add(catelyn);
        visiter.add(aerys);
        visiter.add(bronn);
        visiter.add(sansa);
        visiter.add(willy);
        //10.
        wahlhaibecken.addTier(joffrey);
        //11.
        landgehege1.addTier(tywin);
        //12.
        sansa.setEnclosure(landgehege1);
        //13.
        adlergehege.addTier(cersei);
        //out
        Log.write(zoo.toString());
        Log.write(visiter.toString());
    }
}
