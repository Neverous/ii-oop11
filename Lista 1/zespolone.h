/* 2012
 * Maciej Szeptuch
 * II UWr
 */
#ifndef _ZESPOLONE_H
#define _ZESPOLONE_H

typedef struct
{
  float r,
	i;
} Zespolone;

Zespolone *Zespolona(float r, float i);
void dodaj(Zespolone *a, Zespolone *b);
void odejmij(Zespolone *a, Zespolone *b);
void pomnoz(Zespolone *a, Zespolone *b);
void podziel(Zespolone *a, Zespolone *b);
Zespolone *dodaj_n(Zespolone *a, Zespolone *b);
Zespolone *odejmij_n(Zespolone *a, Zespolone *b);
Zespolone *pomnoz_n(Zespolone *a, Zespolone *b);
Zespolone *podziel_n(Zespolone *a, Zespolone *b);

#endif
