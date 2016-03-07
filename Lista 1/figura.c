/* 2012
 * Maciej Szeptuch
 * II UWr
 */
#include<stdio.h>
#include<stdlib.h>
#include "figura.h"

void narysuj(Figura *f)
{
	printf("Rysuje ");
	switch(f->typfig)
	{
		case PUNKT:
			printf("punkt");
			break;

		case OKRAG:
			printf("okrag o środku");
			break;

		case KWADRAT:
			printf("kwadrat o środku");
			break;
	};

	printf(" (%.2f, %.2f)", f->x, f->y);

	switch(f->typfig)
	{
		case PUNKT:
			break;

		case OKRAG:
			printf(" i promieniu %.2f", f->dlugosc);
			break;

		case KWADRAT:
			printf(" i dlugosci %.2f", f->dlugosc);
			break;
	};
	puts("");
	return;
}

void przesun(Figura *f, float x, float y)
{
	f->x += x;
	f->y += y;
	return;
}

int zawiera(Figura *f, float x, float y)
{
	switch(f->typfig)
	{
		case PUNKT:
			return x == f->x && y == f->y;
			break;

		case OKRAG:
			return (x - f->x) * (x - f->x) + (y - f->y) * (y - f->y) <= f->dlugosc * f->dlugosc;
			break;

		case KWADRAT:
			return x >= f->x - f->dlugosc / 2 && x <= f->x + f->dlugosc / 2 &&
				   y >= f->y - f->dlugosc / 2 && y <= f->y + f->dlugosc / 2;
			break;
	}

	return -1;
}

Figura *Punkt(float x, float y)
{
	Figura *f = (Figura *) malloc(sizeof(Figura));
	f->typfig = PUNKT;
	f->x = x;
	f->y = y;
	f->dlugosc = 0;
	return f;
}

Figura *Okrag(float x, float y, float r)
{
	Figura *f = (Figura *) malloc(sizeof(Figura));
	f->typfig = OKRAG;
	f->x = x;
	f->y = y;
	f->dlugosc = r;
	return f;
}

Figura *Kwadrat(float x, float y, float a)
{
	Figura *f = (Figura *) malloc(sizeof(Figura));
	f->typfig = KWADRAT;
	f->x = x;
	f->y = y;
	f->dlugosc = a;
	return f;
}
