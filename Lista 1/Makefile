all: 2 3

2: 2.o figura.o
	gcc $(CFLAGS) $^ -o 2

3: 3.o zespolone.o
	gcc $(CFLAGS) $^ -o 3

%.o: %.c
	gcc $(CFLAGS) -c $< -o $@

clean:
	rm *.o 2 3
