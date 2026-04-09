# Bohnanza Umsetzung

## 1. Architektur

Die Anwendung wird als **Konsolenanwendung in Java** umgesetzt.

Die Architektur besteht aus zwei klar getrennten Bereichen:

* **Core (Spiellogik)**
  Enthält alle Regeln, Zustände und Spielabläufe

* **UI (Konsole)**
  Zuständig für Ein- und Ausgabe (Benutzerinteraktion über Terminal)

Die Spiellogik ist unabhängig von der UI und kann später erweitert werden (z. B. GUI).

---

## 2. Game State (Zustandsmodell)

Der gesamte Spielzustand wird zentral verwaltet.

### GameState enthält:

* Liste aller Spieler
* Aktiver Spieler (Index)
* Nachziehstapel (draw pile)
* Ablagestapel (discard pile)
* Tischkarten (Handelsphase)
* Aktuelle Phase

```java
class GameState {
    List<Player> players;
    int activePlayerIndex;
    Deck drawPile;
    Deck discardPile;
    List<Card> tableCards;
    Phase currentPhase;
}
```

---

### Player enthält:

* Handkarten (geordnet, nicht umsortierbar)
* Bohnenfelder (standardmässig 2, optional erweiterbar auf 3)
* Münzen (als Anzahl gesammelter Karten)

---

### Weitere Klassen

* `Card` → repräsentiert eine Bohnensorte
* `BeanField` → enthält Karten einer Sorte
* `Deck` → verwaltet Kartenstapel

---

## 3. Spielphasen (State Machine)

```java
enum Phase {
    PLANT_FIRST,
    PLANT_OPTIONAL,
    TRADE,
    PLANT_TRADE,
    DRAW
}
```

### Übergänge

* PLANT_FIRST → PLANT_OPTIONAL
* PLANT_OPTIONAL → TRADE
* TRADE → PLANT_TRADE
* PLANT_TRADE → DRAW
* DRAW → nächster Spieler (PLANT_FIRST)

---

## 4. State Transitions

### Pflanzen

* Erste Karte der Hand wird gespielt
* Falls kein passendes Feld vorhanden ist, muss zuerst geerntet werden

---

### Ernten

* Bohnenfeld wird geleert
* Anzahl Karten wird bestimmt

Fall 1: genügend Bohnen

* Münzen werden berechnet
* entsprechende Karten werden als Münzen gezählt
* restliche Karten → Ablagestapel

Fall 2: zu wenig Bohnen

* 0 Münzen
* alle Karten → Ablagestapel

---

### Handelsphase

* Zwei Karten werden vom Nachziehstapel aufgedeckt → Tischkarten

Spieler können:

* Karten tauschen
* Karten verschenken
* Karten aus der eigenen Hand anbieten

Am Ende der Handelsphase:

* Alle Tischkarten müssen gepflanzt werden
* Falls kein Platz vorhanden ist, muss geerntet werden

---

### Feld kaufen

* Spieler kann ein drittes Bohnenfeld kaufen

* Kosten: 3 Münzen

* Verwendete Münzen (Karten) werden auf den **Ablagestapel gelegt**

---

### Nachziehen

* Der Spieler zieht 3 Karten vom Nachziehstapel
* Karten werden in gezogener Reihenfolge hinten an die Hand angelegt

---

### Spielerwechsel

* Der nächste Spieler wird aktiv
* Phase wird auf `PLANT_FIRST` zurückgesetzt

---

## 5. Münzsystem

```java
class Card {
    BeanType type;
}
```

```java
class BeanType {
    String name;
    Map<Integer, Integer> beanToCoinRate;
}
```

### Funktionsweise

* Die Anzahl gleicher Bohnen bestimmt die Münzen
* Jede Bohnensorte hat eine eigene Wertetabelle
* Münzen werden durch Karten dargestellt
* Verwendete oder abgelegte Karten gehen auf den Ablagestapel

---

## 6. Kartenfluss

* Alle gespielten, geernteten oder verwendeten Karten gehen auf den **Ablagestapel**

* Wenn der Nachziehstapel leer ist:

  * wird der Ablagestapel gemischt
  * und als neuer Nachziehstapel verwendet

* Dieser Vorgang wird **dreimal durchgeführt**

---

## 7. Spielende

* Das Spiel endet, nachdem der Nachziehstapel **dreimal vollständig aufgebraucht wurde**
* Der Spieler mit den meisten Münzen gewinnt

---

## 8. Funktionale Ansätze

* Spielzustände werden nicht direkt verändert
* Methoden erzeugen neue GameStates
* Seiteneffekte werden minimiert

Verwendete Patterns:

* Immutable Data (teilweise)
* Pure Functions
* State Transition Pattern
* Separation of Concerns

---

## 9. Technische Entscheidungen

* Programmiersprache: Java
* Libraries: Standard Java (`List`, `Map`, `Scanner`)

---

## 10. Umsetzungsschritte

1. Erstellung der Klassenstruktur
2. Implementierung der Spiellogik (Pflanzen, Ernten)
3. Integration des Münzsystems
4. Umsetzung der Spielphasen
5. Implementierung des Turn-Systems
6. Entwicklung der Konsolenoberfläche
7. Testing und Fehlerbehebung

---

## 11. Zeitplan

| Tag   | Aufgabe                                                  |
| ----- | -------------------------------------------------------- |
| Tag 1 | Projektstruktur, Klassen (GameState, Player, Card, Deck) |
| Tag 2 | Grundlogik (Pflanzen, Ernten, Bohnenfelder)              |
| Tag 3 | Handelsphase und Kartenfluss                             |
| Tag 4 | Phasenmodell und Turn-System                             |
| Tag 5 | Konsolen-UI, Testing und Bugfixes                        |

---

## 12. Teamaufteilung

---

### **Piera**

* Implementierung der Spielphasen:

  * Phase 3: Handelsphase
  * Phase 4: Pflanzen der Handelskarten

* Umsetzung des Münzsystems:

  * Berechnung der Münzen beim Ernten
  * Verwaltung der Münzen (Karten als Coins)

* Unterstützung bei Integration und Testing

---

### **Shashvina**

* Implementierung der Spielphasen:

  * Phase 1: Pflicht-Pflanzen
  * Phase 2: Optionales Pflanzen

* Umsetzung des Kartenflusses:

  * Ablagestapel und Nachziehstapel
  * Mischen des Ablagestapels bei leerem Nachziehstapel
  * Verwaltung der drei Durchläufe des Stapels

* Unterstützung bei Integration und Testing

---

### **Gemeinsam**

* Implementierung des GameState und grundlegender Klassen
* Entwicklung der Konsolenoberfläche (Ein- und Ausgabe)
* Integration aller Komponenten
* Testing des gesamten Spielablaufs
* Debugging und Fehlerbehebung

---

## 13. Proof of Concept (PoC)

Der Proof of Concept umfasst:

* Spiel mit mindestens **2 Spielern** (erweiterbar auf mehr)
* Vollständiger Spielablauf:

  * Pflanzen (Pflicht + optional)
  * Ernten (falls notwendig oder freiwillig)
  * Handelsphase
  * Pflanzen der Handelskarten
  * Nachziehen
  * Spielerwechsel
* Ernten und Münzberechnung funktionieren korrekt
* Kauf eines dritten Bohnenfeldes möglich
* Kartenfluss (draw/discard) funktioniert korrekt
* Spiel endet regelkonform

---

## 14. Enforcement

* Alle Regeln werden im Code überprüft
* Ungültige Aktionen werden verhindert
* Spieler können nur gültige Aktionen ausführen

---

## 15. Code-Struktur

```
src/
  model/
  logic/
  ui/
```