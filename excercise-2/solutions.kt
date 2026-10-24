
// Svaki zadatak je posebna funkcija (zadatak1A(), zadatak1B(), ...),
// a pomoćne funkcije i klase nalaze se izvan njih.
// Sve se poziva iz main() funkcije na dnu fajla.


// POMOĆNE FUNKCIJE I KLASE

// ---------- 1A ----------
fun uFahrenheit(c: Double): Double {
    return c * 9 / 5 + 32
}

fun ispisiTemperaturu(c: Double) {
    println("Za $c °C = ${uFahrenheit(c)} °F")
}

// ---------- 1B ----------
fun brojCifara(n: Int): Int {
    if (n == 0) return 1
    var broj = 0
    var ostatak = n
    if (ostatak < 0) {
        ostatak *= -1
    }
    while (ostatak > 0) {
        broj++
        ostatak /= 10
    }
    return broj
}

fun zbirCifara(n: Int): Int {
    var suma = 0
    var ostatak = n
    if (ostatak < 0) {
        ostatak *= -1
    }
    while (ostatak > 0) {
        suma += ostatak % 10
        ostatak /= 10
    }
    return suma
}

// ---------- 2A ----------
fun veci(a: Int, b: Int) = when {
    a > b -> a
    else -> b
}

fun jePunoljetan(godine: Int) = when {
    godine >= 18 -> true
    else -> false
}

fun punoIme(ime: String, prezime: String) = println("$ime $prezime")

// ---------- 3A ----------
fun pozdrav(ime: String, pozdrav: String = "Zdravo", uzvik: Boolean = true): String {
    if (uzvik) return "$pozdrav, $ime!"
    else return "$pozdrav, $ime."
}

// ---------- 3B ----------
fun napraviEmail(
    ime: String,
    prezime: String,
    domena: String = "student.ba",
    saGodinom: Int = 0
): String {
    if (saGodinom == 0) {
        return "${ime.lowercase()}.${prezime.lowercase()}@${domena.lowercase()}"
    } else {
        return "${ime.lowercase()}.${prezime.lowercase()}$saGodinom@${domena.lowercase()}"
    }
}

// ---------- 6A ----------
fun primijeni(broj: Int, transformacija: (Int) -> Int): Int {
    return transformacija(broj)
}

// ---------- 6B ----------
fun prebroji(niz: IntArray, uslov: (Int) -> Boolean): Int {
    var broj = 0
    for (i in niz) {
        if (uslov(i)) broj++
    }
    return broj
}

// ---------- 7A ----------
fun Prekidac(ukljucen: Boolean, onToggle: (Boolean) -> Unit) {
    if (ukljucen) {
        println("Prekidac je UKLJUČEN - klik !")
    } else {
        println("Prekidac je ISKLJUČEN - klik !")
    }
    onToggle(!ukljucen)
}

// ---------- 7B ----------
fun Dijalog(
    poruka: String,
    korisnikPotvrdio: Boolean,
    onPotvrdi: () -> Unit,
    onOdustani: () -> Unit = {}
) {
    println(poruka)
    if (korisnikPotvrdio) {
        onPotvrdi()
    } else {
        onOdustani()
    }
}

// ---------- 8B ----------
fun opisImena(ime: String?): String {
    if (ime != null) {
        return "$ime (${ime.length} slova)"
    } else {
        return "nepoznato"
    }
}

// ---------- 9A ----------
fun prikazKorisnika(ime: String?) = "Korisnik: ${ime ?: "Gost"}"

// ---------- 9B ----------
fun prosjekOcjena(unosi: Array<String?>): Double? {
    var suma = 0
    var broj = 0
    for (i in unosi) {
        val ocjena = i?.toIntOrNull() ?: 0
        if (ocjena in 5..10) {
            suma += ocjena
            broj++
        }
    }
    if (broj == 0) return null
    return suma.toDouble() / broj
}

// ---------- 12A ----------
class Knjiga(
    val naslov: String,
    val autor: String,
    var procitanoStranica: Int = 0
) {
    fun citaj(stranice: Int) {
        procitanoStranica += stranice
    }

    fun opis() {
        println("$naslov - $autor, pročitano: $procitanoStranica str.")
    }
}

// ---------- 12B ----------
class BankovniRacun(val vlasnik: String, pocetnoStanje: Double = 0.0) {
    var historija = mutableListOf<String>()
    var stanje = pocetnoStanje

    fun uplati(iznos: Double) {
        stanje += iznos
        historija.add("+$iznos")
    }

    fun isplati(iznos: Double): Boolean {
        if (stanje >= iznos) {
            stanje -= iznos
            historija.add("-$iznos")
            return true
        } else {
            historija.add("odbijeno -$iznos")
            return false
        }
    }

    fun opis() {
        println("$vlasnik, stanje: $stanje KM")
    }
}

// ---------- 13A ----------
data class Student(val ime: String, val prosjek: Double)

// ---------- 13B ----------
data class Film(val naslov: String, val godina: Int, val ocjena: Double, val zanr: String)



// 01 · FUNKCIJE

fun zadatak1A() {
    ispisiTemperaturu(0.0)
    ispisiTemperaturu(25.0)
    ispisiTemperaturu(100.0)
}

fun zadatak1B() {
    val niz = intArrayOf(12345, -907, 0)
    for (i in niz) {
        println("$i: cifara ${brojCifara(i)}, zbir ${zbirCifara(i)}")
    }
}

fun zadatak2A() {
    println(veci(4, 9))
    println(jePunoljetan(17))
    punoIme("Amina", "Hodžić")
}

fun zadatak2B() {
    fun nazivDana(broj: Int) = when (broj) {
        1 -> "Ponedjeljak"
        2 -> "Utorak"
        3 -> "Srijeda"
        4 -> "Četvrtak"
        5 -> "Petak"
        6, 7 -> "Vikend"
        else -> "Nepostojeći dan"
    }

    fun jePrestupna(godina: Int) = (godina % 4 == 0 && godina % 100 != 0) || godina % 400 == 0

    println(nazivDana(1))
    println(nazivDana(6))
    println(nazivDana(9))

    for (i in listOf(2024, 1900, 2000, 2026)) {
        println("$i prestupna: ${jePrestupna(i)}")
    }
}

fun zadatak3A() {
    println(pozdrav("Faris"))
    println(pozdrav("Faris", "Dobro jutro"))
    println(pozdrav("Faris", uzvik = false))
}

fun zadatak3B() {
    println(napraviEmail("Amina", "Hodzic"))
    println(napraviEmail("Amina", "Hodzic", "FIRMA.BA"))
    println(napraviEmail("Amina", "Hodzic", saGodinom = 2026))
    println(napraviEmail(domena = "etf.ba", prezime = "Begic", ime = "Haris"))
}



// 02 · LAMBDE

fun zadatak4A() {
    val pomnozi = { a: Int, b: Int -> a * b }
    val jeNegativan: (a: Int) -> Boolean = { a -> a < 0 }
    val zaglavlje: () -> Unit = {
        println("=== Kalkulator ===")
    }

    zaglavlje()
    println(pomnozi(6, 7))
    println(jeNegativan(-5))
    println(jeNegativan(3))
}

fun zadatak4B() {
    val inicijali: (String, String) -> String = { ime, prezime ->
        "${ime[0]}.${prezime[0]}."
    }
    val opisTemperature: (Int) -> String = { opis ->
        when {
            opis <= 0 -> "ledeno"
            opis <= 15 -> "hladno"
            opis <= 25 -> "ugodno"
            else -> "vruće"
        }
    }

    println(inicijali("Hedija", "Šišić"))
    println("-4 stepen je ${opisTemperature(-4)}")
    println("20 stepen je ${opisTemperature(20)}")
    println("31 stepen je ${opisTemperature(31)}")
}

fun zadatak5A() {
    val lam1: (Int) -> Int = { it * 3 }
    println(lam1(7))

    val lam2: (String) -> String = { it.uppercase() }
    println(lam2("kotlin"))

    val lam3: (Int) -> Boolean = { it > 0 }
    println(lam3(-1))
}

fun zadatak5B() {
    val jePalindrom: (String) -> Boolean = { it.lowercase() == it.lowercase().reversed() }
    val brojSamoglasnika: (String) -> Int = { tekst ->
        tekst.lowercase().count { it in "aeiou" }
    }
    println(jePalindrom("Ana"))
    println(jePalindrom("Kotlin"))
    println(brojSamoglasnika("Programiranje"))
}

fun zadatak6A() {
    println(primijeni(5, { x -> x + x }))
    println(primijeni(5, { x -> x + 10 }))
    println(primijeni(5, { x -> x * x }))
}

fun zadatak6B() {
    val niz = intArrayOf(4, -7, 15, 22, -1, 8, 13, 0)
    println("Parnih: ${prebroji(niz, { x -> x % 2 == 0 })}")
    println("većih od 10: ${prebroji(niz, { x -> x > 10 })}")
    println("Negativnih: ${prebroji(niz, { x -> x < 0 })}")
}

fun zadatak7A() {
    var svjetlo = false
    Prekidac(svjetlo, { novoStanje -> svjetlo = novoStanje })
    println("Svjetlo: $svjetlo")
    Prekidac(svjetlo) { svjetlo = it }
    println("Svjetlo: $svjetlo")
}

fun zadatak7B() {
    var obrisano = 0
    print("Dijalog: ")
    Dijalog("Obrisati poruku?", korisnikPotvrdio = true, { obrisano++ })
    print("Dijalog: ")
    Dijalog(
        poruka = "Obrisati sve?",
        korisnikPotvrdio = false,
        onPotvrdi = { obrisano + 10 },
        onOdustani = { println("Brisanje otkazano \nObrisano poruka: $obrisano") }
    )
}



// 03 · NULL SAFETY


fun zadatak8A() {
    var grad: String? = null
    println(grad?.length)
    println(grad?.uppercase())
    grad = "Mostar"
    println(grad.length)
    println(grad.uppercase())
}

fun zadatak8B() {
    val niz = arrayOf<String?>("Amina", null, "Faris", null, "Ena")
    var neNull = 0
    for (i in niz) {
        if (i != null) neNull++
        println(opisImena(i))
    }
    println("Poznatih imena: $neNull")
}

fun zadatak9A() {
    println(prikazKorisnika("Hedija"))
    println(prikazKorisnika(null))
    val a = "15".toIntOrNull() ?: 0
    val b = "abc".toIntOrNull() ?: 0
    println(a + b)
}

fun zadatak9B() {
    val niz1 = arrayOf<String?>("8", "x", null, "10", "9", "15")
    val niz2 = arrayOf<String?>("abc", null, "")
    println("Prosjek: ${prosjekOcjena(niz1) ?: "Nema ocjena"}")
    println("Prosjek: ${prosjekOcjena(niz2) ?: "Nema ocjena"}")
}



// 04 · KOLEKCIJE

fun zadatak10A() {
    val lista = listOf(12, -3, 25, 7, -8, 30)
    lista.forEach { println("Izmjereno: $it") }

    val iznadNule = lista.filter { it > 0 }
    println(iznadNule)

    val saStepenima = lista.map { it.toString() + "°C" }
    println(saStepenima)
}

fun zadatak10B() {
    var imena = mutableListOf("amina", "faris", "ena", "haris", "ema", "ado")
    imena.remove("ado")
    imena.add("selma")
    var novaImena = imena.filter { it.length >= 5 }
        .map { it.replaceFirstChar { c -> c.uppercase() } }

    novaImena.forEachIndexed { i, ime ->
        println("${i + 1}. $ime")
    }
    println(novaImena.joinToString(", "))
}

fun zadatak11A() {
    val lista = listOf(12, 5, 21, 40, 7, 63)
    val djeljiviSaSedam = lista.find { (it % 7) == 0 }
    println("Prvi djeljiv sa 7: ${djeljiviSaSedam}")

    val prviOdSto = lista.find { it > 100 }
    println("Prvi veci od 100: ${prviOdSto ?: "nema"}")
}

fun zadatak11B() {
    val lista = listOf("kotlin", "java", "kompajler", "lambda", "klasa", "android")
    val novaLista = lista.filter { it.startsWith("k") }
        .map { it.length }
    println(novaLista)
    println("Ukupno slova: ${novaLista.sum()}")

    val najduzaOdSedam = lista.find { it.length > 7 }
    println(najduzaOdSedam?.uppercase() ?: "nema")

    val najduzaOd12 = lista.find { it.length > 12 }
    println(najduzaOd12?.uppercase() ?: "Nema duge riječi")
}



// 05 · KLASE

fun zadatak12A() {
    val knjiga1 = Knjiga("\"Derviš i smrt\"", "Meša Selimović")
    val knjiga2 = Knjiga("\"Na Drini ćuprija\"", "Ivo Andrić", 50)

    knjiga1.citaj(30)
    knjiga1.citaj(20)

    knjiga1.opis()
    knjiga2.opis()
}

fun zadatak12B() {
    val racun = BankovniRacun("Amina", 100.0)
    racun.uplati(50.0)
    println("Isplata 120: ${racun.isplati(120.0)}")
    println("Isplata 200: ${racun.isplati(200.0)}")
    racun.opis()
    println("Historija: ${racun.historija}")
}

fun zadatak13A() {
    val student1 = Student("Hedija", 8.62)
    val student2 = Student("Hedija", 8.62)
    println(student1)
    println(student1 == student2)
    val student3 = student1.copy(prosjek = 9.1)
    println(student3)
}

fun zadatak13B() {
    val filmovi = listOf(
        Film("Inception", 2010, 8.8, "SF"),
        Film("Coco", 2017, 8.4, "Animirani"),
        Film("Interstellar", 2014, 8.7, "SF"),
        Film("Cars 2", 2011, 6.2, "Animirani"),
        Film("Tenet", 2020, 7.3, "SF")
    )

    val dobraOcjena = filmovi.filter { it.ocjena >= 8.5 }
        .map { it.naslov }
    println("Ocjena 8.5+: ${dobraOcjena}")

    val animirani = filmovi.find { it.godina > 2015 }
    println("Novi animirani: ${animirani?.naslov ?: "nema"}")

    val horror = filmovi.find { it.zanr == "Horror" }
    println("Horror: ${horror?.naslov ?: "nema"}")

    val prosjecnaOcjena = filmovi.sumOf { it.ocjena } / filmovi.size
    println("Prosječna ocjena: $prosjecnaOcjena")

    val filmoviIspravljeno = filmovi[4].copy(ocjena = 7.5)
    println(filmoviIspravljeno)
}



// Pozivanje svih zadataka:

fun naslov(oznaka: String) {
    println()
    println("===== Zadatak $oznaka =====")
}

fun main() {
    naslov("1A"); zadatak1A()
    naslov("1B"); zadatak1B()
    naslov("2A"); zadatak2A()
    naslov("2B"); zadatak2B()
    naslov("3A"); zadatak3A()
    naslov("3B"); zadatak3B()

    naslov("4A"); zadatak4A()
    naslov("4B"); zadatak4B()
    naslov("5A"); zadatak5A()
    naslov("5B"); zadatak5B()
    naslov("6A"); zadatak6A()
    naslov("6B"); zadatak6B()
    naslov("7A"); zadatak7A()
    naslov("7B"); zadatak7B()

    naslov("8A"); zadatak8A()
    naslov("8B"); zadatak8B()
    naslov("9A"); zadatak9A()
    naslov("9B"); zadatak9B()

    naslov("10A"); zadatak10A()
    naslov("10B"); zadatak10B()
    naslov("11A"); zadatak11A()
    naslov("11B"); zadatak11B()

    naslov("12A"); zadatak12A()
    naslov("12B"); zadatak12B()
    naslov("13A"); zadatak13A()
    naslov("13B"); zadatak13B()
}