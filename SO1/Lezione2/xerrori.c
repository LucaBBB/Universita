#include "xerrori.h"


void die(const char *s) {
    perror(s);
    exit(1);
}

FILE *xfopen(const char *pathname, const char *mode, const char *file, const int line) {
    FILE *f = fopen(pathname, mode);
    if (f == NULL) {
        perror("Errore apertura file");
        fprintf(stderr, "(%s:%d)\n", file, line);
        exit(1);
    }
    return f;
}

/*
 * fork(): crea un processo figlio.
 * Il padre riceve il PID del figlio, ed il figlio riceve '.
 * Se il padre riceve -1, la fork() ha fallito e non e' stato creato  nessun figlio.
 */
pid_t xfork(const char *file, const int line) {
    pid_t p = fork();
    if (p < 0) {
        perror("Errore chiamata fork");
        fprintf(stderr, "(%s:%d)\n", file, line);
        exit(1);
    }
    return p;
}

/*
 *  wait(status): sospende il processo corrente finche' un figlio termina oppure il processo corrente riceve
 *  un segnale di terminazione.
 */
pid_t xwait(int *status, const char *file, const int line) {
    pid_t p = wait(status);
    if (p < 0) {
        perror("Errore chiamata wait");
        fprintf(stderr, "(%s:%d)\n", file, line);
        exit(1);
    }
    return p;
}
