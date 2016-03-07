/* 2012
 * Maciej Szeptuch
 * II UWr
 */
#include<stdio.h>
#include<stdlib.h>
#include "zespolone.h"

int main(void)
{
	Zespolone *a, *b, *c, *r;
	a = Zespolona(1.0, 15.0);
	printf("a = %.2f + %.2fi\n", 1.0, 15.0);
	b = Zespolona(1.0, 22.7);
	printf("b = %.2f + %.2fi\n", 1.0, 22.7);
	c = Zespolona(-10.15, 27.23);
	printf("c = %.2f + %.2fi\n", -10.15, 27.23);

	dodaj(a, b);
	printf("a = a + b = %.2f + %.2fi\n", a->r, a->i);

	odejmij(c, a);
	printf("c = c - a = %.2f + %.2fi\n", c->r, c->i);

	pomnoz(c, b);
	printf("c = c * b = %.2f + %.2fi\n", c->r, c->i);

	podziel(b, a);
	printf("b = b / a = %.2f + %.2fi\n", b->r, b->i);

	r = dodaj_n(a, b);
	printf("r = a + b = %.2f + %.2fi\n", r->r, r->i);
	free(r);

	r = odejmij_n(a, b);
	printf("r = a - b = %.2f + %.2fi\n", r->r, r->i);
	free(r);

	r = podziel_n(c, b);
	printf("r = c / b = %.2f + %.2fi\n", r->r, r->i);
	free(r);

	r = pomnoz_n(c, a);
	printf("r = c * a = %.2f + %.2fi\n", r->r, r->i);
	free(r);

	return 0;
}
