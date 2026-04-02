# Bohnanza – Digitales Brettspiel

## Projektbeschreibung

In diesem Projekt wird das Kartenspiel *Bohnanza* digital umgesetzt. Ziel ist es, die Spiellogik korrekt abzubilden und eine spielbare Version für mehrere Spieler bereitzustellen.

Der Fokus liegt auf der fachlichen Spezifikation des Spiels, nicht auf der technischen Umsetzung.

---

## Ziele

* Entwicklung eines vollständig spielbaren Bohnanza-Spiels
* Umsetzung der offiziellen Spielregeln
* Klare und verständliche Benutzerinteraktion
* Unterstützung von mindestens zwei Spielern

---

## Use Cases

* Ein Spiel wird gestartet
* Spieler führen ihre Spielzüge aus
* Spieler pflanzen, handeln und ernten Bohnen
* Spieler können ihren aktuellen Spielstand einsehen
* Das Spiel endet automatisch
* Der Gewinner wird bestimmt

---

## Spielregeln

### Grundprinzip

Die Spieler bauen Bohnen an, handeln Karten und ernten diese, um Münzen zu erhalten. Ziel ist es, am Ende des Spiels die meisten Münzen zu besitzen.

---

### Handkarten

* Jeder Spieler besitzt zu Beginn 5 Karten
* Die Reihenfolge der Karten darf nicht verändert werden
* Karten müssen von vorne gespielt werden
* Neue Karten werden hinten an die Hand angelegt

---

### Ablauf eines Spielzugs

1. Die erste Handkarte muss gepflanzt werden
2. Optional kann eine zweite Karte gepflanzt werden
3. Es werden zwei Karten vom Nachziehstapel aufgedeckt und zum Handeln angeboten
4. Wenn kein anderer Spieler die Karten nimmt, muss der aktive Spieler sie selbst aufnehmen
5. Falls der Spieler keinen Platz mehr hat, muss er ein Feld abernten oder ein zusätzliches Feld kaufen
6. Danach ist der nächste Spieler an der Reihe

---

### Bohnenfelder

* Jeder Spieler besitzt standardmässig zwei Bohnenfelder
* Jedes Feld darf nur eine Bohnensorte enthalten
* Optional kann ein weiteres Bohnenfeld für 3 Münzen gekauft werden

---

### Ernten

* Spieler können jederzeit Bohnen ernten
* Die Anzahl der Münzen hängt von der Menge gleicher Bohnen ab

---

### Spielende

Das Spiel endet, nachdem der Nachziehstapel dreimal vollständig durchgespielt wurde.

---

## Constraints

* Handkarten dürfen nicht umsortiert werden
* Es dürfen nur gültige Spielzüge ausgeführt werden
* Jeder Spieler besitzt mindestens zwei Bohnenfelder
* Das Spiel ist rundenbasiert organisiert
* Die Regeln werden vollständig durch das System überprüft

---

## Akzeptanzkriterien

### Mindestanforderungen

* Die Spiellogik entspricht den definierten Regeln
* Karten werden in der vorgegebenen Reihenfolge gespielt
* Regeln für Pflanzen und Ernten werden korrekt umgesetzt
* Ungültige Aktionen sind nicht möglich
* Das Spiel ist von Anfang bis Ende spielbar
* Der Gewinner wird korrekt ermittelt

---

### Definition der korrekten Spiellogik

Korrekte Spiellogik bedeutet, dass alle Spielregeln eingehalten werden und keine Regelverstösse durch Benutzeraktionen möglich sind. Alle Spielzustände müssen konsistent bleiben.

---

## Grundlegende Interaktion

### Aktionen des Spielers

Ein Spieler kann:

* Karten pflanzen
* Karten handeln
* Bohnen ernten
* Felder kaufen
* seinen aktuellen Spielstatus einsehen

---

### Spielerwechsel

Das Spiel ist rundenbasiert. Jeder Spieler führt seinen vollständigen Zug aus, danach wechselt das Spiel automatisch zum nächsten Spieler.

---