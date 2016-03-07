/* 2012
 * Maciej Szeptuch
 * II UWr
 */
#include<stdio.h>
#include "figura.h"

int main(void)
{
	Figura *a, *b, *c;
	a = Punkt(0, 0), 
	b = Okrag(0, 0, 5),
	c = Kwadrat(0, 0, 10);

	// Rysowanie
	narysuj(a);
	narysuj(b);
	narysuj(c);

	// Przesuwanie
	przesun(a, -15.2, 17.1);
	przesun(b, 23, 1.1);
	przesun(c, 15.33, -89.934);
	
	// Rysowanie
	narysuj(a);
	narysuj(b);
	narysuj(c);

	// Zawieranie
	printf("(%.2f, %.2f) zawiera się w punkcie (%.2f, %.2f)? %s\n",
		0.0, 0.0, a->x, a->y, zawiera(a, 0.0, 0.0)?"TAK":"NIE");

	printf("(%.2f, %.2f) zawiera się w punkcie (%.2f, %.2f)? %s\n",
		-15.2, 17.1, a->x, a->y, zawiera(a, -15.2, 17.1)?"TAK":"NIE");

	printf("(%.2f, %.2f) zawiera się w okregu (%.2f, %.2f) o promieniu %.2f? %s\n",
		-15.2, 17.1, b->x, b->y, b->dlugosc, zawiera(b, -15.2, 17.1)?"TAK":"NIE");

	printf("(%.2f, %.2f) zawiera się w okregu o środku (%.2f, %.2f) i promieniu %.2f? %s\n",
		24.0, 3.0, b->x, b->y, b->dlugosc, zawiera(b, 24.0, 3.0)?"TAK":"NIE");

	printf("(%.2f, %.2f) zawiera się w kwadracie o środku (%.2f, %.2f) i długości %.2f? %s\n",
		20.0, 6.0, c->x, c->y, c->dlugosc, zawiera(c, 20.0, 6.0)?"TAK":"NIE");

	printf("(%.2f, %.2f) zawiera się w kwadracie o środku (%.2f, %.2f) i długości %.2f? %s\n",
		16.0, -90.0, c->x, c->y, c->dlugosc, zawiera(c, 16.0, -90.0)?"TAK":"NIE");

	return 0;
}
