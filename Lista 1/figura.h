/* 2012
 * Maciej Szeptuch
 * II UWr
 */
#ifndef _FIGURA_H
#define _FIGURA_H

typedef enum
{
	PUNKT,
	OKRAG,
	KWADRAT,
} TypFigury;

typedef struct
{
	TypFigury typfig;
	float dlugosc,
		  x, y; // Wyrozniony punkt
} Figura;

void narysuj(Figura *f);
void przesun(Figura *f, float x, float y);
int zawiera(Figura *f, float x, float y);
Figura *Punkt(float x, float y);
Figura *Okrag(float x, float y, float r);
Figura *Kwadrat(float x, float y, float a);

#endif
