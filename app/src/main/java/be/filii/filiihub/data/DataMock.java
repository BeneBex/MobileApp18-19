package be.filii.filiihub.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class DataMock {

    static public List<Event> mockEvents() {
        List<Event> events = new ArrayList<Event>();

        Event event = new Event(new Date(2018, 12, 20), "Blue Thrill Td", "Blue Thrill TD is er weer dit jaar bij. Kom zeker af voor een avond vol met shotjes en bier! Onze geliefde blue thrill shotjes zijn zeker de moeite waard om voor af te komen, zeker als je deze nog niet geproefd hebt! ", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2018, 11, 27), "Boardgame Night", "BoardGame night bij Cegeka, samen met Filii Lamberti en Hexion. Een gezellige spelletjesavond met eten en drinken.", "Cegeka Hasselt");
        events.add(event);
        event = new Event(new Date(2018, 12, 31), "New Year", "Het zag er vorig jaar naar uit dat we samen met jullie niet meer knallend het nieuwe jaar in konden gaan... Door een heleboel nieuwe ontwikkelingen zijn de pompgebouwen toch weer beschikbaar gekomen!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019, 2, 14), "Valentijn", "Kom heerlijk dineren tijdens ons Valentijnsdiner, onze leden zullen veel liefde in het eten stoppen en de gerechten met passie serveren. Komt u ook?", "Bakkery Hasselt");
        events.add(event);
        event = new Event(new Date(2019, 5, 15), "Ontgroening", "We gaan de schachtjes weer eens goed laten afzien voor de laatste keer!",
                "Cantuszaal zonhoven");
        events.add(event);
        event = new Event(new Date(2019, 5, 18), "Verkiezingen", "Diepenbeek ! Zijn jullie er klaar voor !? De koude dagen zijn bijna voorbij, wat wilt zeggen dat het tijd wordt voor de epische Praesesverkiezingen !", "Weide unief");
        events.add(event);
        event = new Event(new Date(2019, 6, 28), "Summer Begins TD", "Zijn jullie de examens nu al meer dan beu? " +
                "Hebben jullie ook genoeg van de te volle bib, die ene zagende klasgenoot, dat overdreven warme niet-blok-weertje en die verdomde locker die doet alsof hij nog vrij is maar eigenlijk gewoon al meer dan de helft van de blok kapot is? Dan hebben wij de oplossing!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019, 7, 3), "Overdracht", "We zijn weer daar, tijd voor het oude om plaats te maken voor het nieuwe. De kleine worden groot, de nieuwe staan op en zullen zich bewijzen met hun grootse overtuigingszin. Dat is toch de bedoeling normaal, je kan natuurlijk ook komen kijken hoe onze verkozen jongen probeert recht te staan en boven de tafel kruipt om nog maar eens een pint te drinken, na pint en pint. Of hij nog gaat groeien, hopelijk anders gaan we toch een doos moeten zoeken zodat de jongen met zijn hamer op tafel zal kunnen slaan in plaats van eronder. Kom hem maar dus gewoon wat steunen, want hij kan het gebruiken.", "PXL");
        events.add(event);
        event = new Event(new Date(2019, 7, 30), "painball", "Altijd al met verf op elkaar willen schieten? Nu is je kans!", "Painballterrein Houthalen");
        events.add(event);
        event = new Event(new Date(2019, 8, 8), "Blokdag", "Allemaal samen 8 uur aan een stuk leren!!! ", "thuis");
        events.add(event);
        event = new Event(new Date(2019, 9, 15), "Back to school TD", "Beste studenten van Diepenbeek en omstreken. Helaas is de zomer voorbij... Maar niet getreurd. Nog voordat ge een docent ziet, uw boeken aangeraakt hebt of de verplichte les moet halen, presenteert Kerberus Diepenbeek u zijn fantastische Back to School TD!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019, 9, 15), "Back to college TD", "Beste studenten van Diepenbeek en omstreken. Helaas is de zomer voorbij... Maar niet getreurd. Nog voordat ge een docent ziet, uw boeken aangeraakt hebt of de verplichte les moet halen, presenteert Kerberus Diepenbeek u zijn fantastische Back to School TD!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019, 9, 15), "Back to university TD", "Beste studenten van Diepenbeek en omstreken. Helaas is de zomer voorbij... Maar niet getreurd. Nog voordat ge een docent ziet, uw boeken aangeraakt hebt of de verplichte les moet halen, presenteert Kerberus Diepenbeek u zijn fantastische Back to School TD!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019, 9, 15), "Back to high school TD", "Beste studenten van Diepenbeek en omstreken. Helaas is de zomer voorbij... Maar niet getreurd. Nog voordat ge een docent ziet, uw boeken aangeraakt hebt of de verplichte les moet halen, presenteert Kerberus Diepenbeek u zijn fantastische Back to School TD!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019, 9, 15), "Back to kindergarden TD", "Beste studenten van Diepenbeek en omstreken. Helaas is de zomer voorbij... Maar niet getreurd. Nog voordat ge een docent ziet, uw boeken aangeraakt hebt of de verplichte les moet halen, presenteert Kerberus Diepenbeek u zijn fantastische Back to School TD!", "Fitlink Diepenbeek");
        events.add(event);
        return events;

    }

}
