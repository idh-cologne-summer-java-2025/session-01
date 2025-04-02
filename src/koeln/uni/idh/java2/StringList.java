package koeln.uni.idh.java2;

/**
 * Diese Klasse beschriebt eine String-Liste (Datenstruktur), in die beliebig
 * viele Strings eingefügt und wieder gelöscht werden können. Die Klasse soll
 * die Nachteile eines Arrays, wie etwa die feste Größe oder die beim Löschen
 * einzelner Elemente entstehenden "Lücken", durch das Anbieten verschiedener
 * Hilfsmethoden ausgleichen. Man bezeichnet so etwas auch als eine Abstraktion
 * oder "Wrapper-Klasse", also eine "Verpackung" um etwas.
 * 
 * @author bkis
 *
 */
public class StringList {

	private String[] data; // das String-Array, das intern benutzt wird
	private int nextInsertPosition; // die nächste freie, beschreibbare Stelle des Arrays

	/**
	 * Ein Konstruktor, dem man die gewünschte initiale Größe des internen Arrays
	 * übergeben kann (falls man z.B. schon weiß, dass man bis zu n Elemente
	 * einfügen möchte.
	 * 
	 * @param initialSize
	 */
	public StringList(int initialSize) {
		this.data = new String[initialSize];
		this.nextInsertPosition = 0;
	}

	/**
	 * Ein Konstruktor, dem man ein bereits bestehendes String-Array übergeben kann,
	 * welches als initiale Datenbasis für die StringList verwendet wird.
	 * 
	 * @param initialArray
	 */
	public StringList(String[] initialArray) {
		this.data = initialArray;
		this.nextInsertPosition = initialArray.length;
	}

	/**
	 * Ein Konstruktor, der ganz ohne Argumente auskommt. Hier wird einfach eine
	 * festgelegte Anfangs-Länge des Arrays verwendet, indem ein anderer Konstruktor
	 * mit dem entsprechenden Wert aufgerufen wird.
	 */
	public StringList() {
		this(10); // das Array soll zu Beginn die Länge 10 haben
	}

	/**
	 * Diese Methode fügt der StringList am Ende einen neuen String hinzu.
	 * 
	 * @param s Der String, der hinzugefügt werden soll
	 */
	public void add(String s) {
		if (full())
			grow(); // überprüfen, ob Platz ist; wenn nicht, vergrößern (s.u.)
		data[nextInsertPosition] = s; // den übergebenen String an die nächste freie Stelle schreiben
		nextInsertPosition++; // den Wert für die nächste freie Stelle um 1 erhöhen
	}

	/**
	 * Ersetzt den String an der gewünschten Stelle durch einen anderen
	 * 
	 * @param index Index des zu ersetzenden Elements
	 * @param s     String, durch den ersetzt werden soll
	 */
	public void set(int index, String s) {
		// TODO: Implement!
	}

	/**
	 * Diese Methode entfernt einen String aus der Liste. Hierbei sollen keine
	 * Lücken im internen Array entstehen! Es kann natürlich sein, dass es mehrere
	 * Strings mit dem gleichen Inhalt in der Liste gibt. Es wird daher (als
	 * Kompromisslösung) nur der erste passende String entfernt.
	 * 
	 * WICHTIGER HINWEIS: Strings bitte NIEMALS so vergleichen: if (string1 ==
	 * string2) {...} Sondern IMMER so: if (string1.equals(string2)) {...}
	 *
	 * Grund: Der Vergleichsoperator "==" überprüft, ob es sich um dasselbe Objekt
	 * handelt - er überprüft hingegen nicht, ob es sich um zwei (potentiell
	 * verschiedene) String-Objekte mit dem selben Text-Inhalt handelt!
	 * 
	 * @param toRemove Der String, der entfernt werden soll
	 */
	public void remove(String toRemove) {
		// TODO: implementieren!
	}

	/**
	 * Diese Methode entfernt den String an der Stelle "index" aus der Liste. Auch
	 * hier dürfen keine Lücken entstehen!
	 * 
	 * @param index
	 */
	public void remove(int index) {
		// TODO: implementieren!
	}

	/**
	 * Diese Methode gibt den index des ersten Elements der Liste zurück, das dem
	 * übergebenen String entspricht.
	 * 
	 * WICHTIGER HINWEIS: Siehe Kommentar der Methode remove(...)!
	 * 
	 * @param s String, dessen Index gesucht werden soll
	 * @return Index des gesuchten Strings, oder -1 wenn String nicht enthalten ist.
	 */
	public int indexOf(String s) {
		for (int i = 0; i < data.length; i++) {
			// for (String irgendwas : data) {
			if (s.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Diese Methode gibt den String an der Stelle "index" aus der Liste zurück.
	 * 
	 * @param index Index des Strings, der zurückgegeben werden soll
	 * @return Der String, der zurückgegeben werden soll
	 */
	public String get(int index) {
		if (isIndexValid(index)) {
			return data[index];
		} else {
			return null;
		}
	}

	/**
	 * Diese Methode gibt die StringList im aktuellen Zustand auf der Konsole aus.
	 * Hierfür wird die Klasse StringBuilder aus der Java-Library verwendet, welche
	 * das Verketten von Strings wesentlich beschleunigt (Niemals String in
	 * Schleifen verketten! Das ist sehr langsam wegen der Unveränderbarkeit von
	 * Strings/Arrays!).
	 * 
	 * Einfache Alternative: return Arrays.toString(data);
	 */
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < nextInsertPosition; i++) {
			sb.append(data[i]);
			if (i < nextInsertPosition - 1)
				sb.append(", ");
		}

		sb.append("]");
		System.out.println(sb.toString());
	}

	/**
	 * Kehrt die gesamte Liste um (Reihenfolge der Strings)
	 */
	public void reverseList() {
		// TODO: implementieren!
	}

	/**
	 * Gibt eine neue Instanz von StringList mit den Elementen von "start" bis "end"
	 * (exklusiv) zurück
	 * 
	 * @param start Start-Index der Teil-Liste
	 * @param end   End-Index der Teil-Liste + 1
	 * @return
	 */
	public StringList getSubList(int start, int end) {
		// TODO: implementieren!
		return null;
	}

	/**
	 * Gibt an, wieviele Elemente diese Liste momentan enthält.
	 * 
	 * @return Anzahl der Elemente dieser Liste
	 */
	public int size() {
		// TODO: Implement
		return -1;
	}

	/*
	 * Eine Methode zur internen Verwendung (daher private), die überprüft, ob ein
	 * index überhaupt gültig ist
	 */
	private boolean isIndexValid(int index) {
		return index < nextInsertPosition;
	}

	/*
	 * Eine Methode zur internen Verwendung (daher private), die überprüft, ob das
	 * interne Array bereits "voll" ist, oder ob noch Platz für weitere Elemente zur
	 * Verfügung steht.
	 */
	private boolean full() {
		return data.length <= nextInsertPosition;
	}

	/*
	 * Eine Methode zur internen Verwendung (daher private), die das interne Array
	 * "vergrößert", bzw. (weil das ja nicht geht) ein neues, größeres Array
	 * erzeugt, die Elemente hereinkopiert und der entsprechenden Klassenvariable
	 * die Referenz auf dieses neue Array zuweist.
	 */
	private void grow() {
		// neues Array mit bisheriger Länge + 10
		String[] temp = new String[data.length + 10];

		// alle Elemente ins neue Array kopieren
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}

		// neues Array als intern verwendetes Array festlegen
		this.data = temp;
	}

}