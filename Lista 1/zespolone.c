/* 2012
 * Maciej Szeptuch
 * II UWr
 */
#include<stdlib.h>
#include "zespolone.h"

Zespolone *Zespolona(float r, float i)
{
	Zespolone *z = (Zespolone *) malloc(sizeof(Zespolone));
	z->r = r;
	z->i = i;
	return z;
}

void dodaj(Zespolone *a, Zespolone *b)
{
	a->r += b->r;
	a->i += b->i;
	return;
}

void odejmij(Zespolone *a, Zespolone *b)
{
	a->r -= b->r;
	a->i -= b->i;
	return;
}

void pomnoz(Zespolone *a, Zespolone *b)
{
	Zespolone r = {a->r * b->r - b->i * a->i, a->i * b->r + a->r * b->i};
	a->r = r.r;
	a->i = r.i;
	return;
}

void podziel(Zespolone *a, Zespolone *b)
{
	if(!b->i && !b->r) // Dzielenie przez 0
		return;

	Zespolone r = {(a->r * b->r + b->i * a->i) / (b->r * b->r + b->i * b->i),
				   (a->i * b->r - a->r * b->i) / (b->r * b->r + b->i * b->i)};
	a->r = r.r;
	a->i = r.i;
	return;
}

Zespolone *dodaj_n(Zespolone *a, Zespolone *b)
{
	Zespolone *r = (Zespolone *) malloc(sizeof(Zespolone));
	r->r = a->r + b->r;
	r->i = a->i + b->i;
	return r;
}

Zespolone *odejmij_n(Zespolone *a, Zespolone *b)
{
	Zespolone *r = (Zespolone *) malloc(sizeof(Zespolone));
	r->r = a->r - b->r;
	r->i = a->i - b->i;
	return r;
}

Zespolone *pomnoz_n(Zespolone *a, Zespolone *b)
{
	Zespolone *r = (Zespolone *) malloc(sizeof(Zespolone));
	r->r = a->r * b->r + a->i * b->i;
	r->i = a->i * b->r + a->r * b->i;
	return r;
}

Zespolone *podziel_n(Zespolone *a, Zespolone *b)
{
	if(!b->i && !b->r) // Dzielenie przez 0
		return NULL;

	Zespolone *r = (Zespolone *) malloc(sizeof(Zespolone));
	r->r = (a->r * b->r + a->i * b->i) / (b->r * b->r + b->i * b->i);
	r->i = (a->i * b->r + a->r * b->i) / (b->r * b->r + b->i * b->i);
	return r;
}
