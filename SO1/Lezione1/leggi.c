//
// Created by luca on 02/01/20.
//

#include "xerrori.h"

void leggi1n(char *nome) {
    // apre file in lettura
    FILE *f = fopen(nome, "rb");
    assert(f != NULL);
    int i, e, somma = 0;
    // inizia a leggere il file finche' non arriva in fondo
    while ((!feof(f)) && (xfread(&i, sizeof(int), 1, f, __FILE__, __LINE__) != 0)) {
        e = xfread(&i, sizeof(int), 1, f, __FILE__, __LINE__);
        somma += i;
    }
    printf("somme: %d\n", somma);
    // chiude file
    e = fclose(f);
    if (e != 0) {
        perror("Errore chiusura file");
        exit(1);
    }
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Uso:\n\t%s nomefile\n\n", argv[0]);
        exit(1);
    }
    leggi1n(argv[2]);
}