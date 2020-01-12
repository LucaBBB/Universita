#include "xerrori.h"

/*
 * int fd = open(nome,O_WRONLY|O_CREAT|O_TRUNC,0666);
 * 1)   apre il file con un certo "nome";
 * 2)   il file sara' aperto in scrittura andando all'inizio del file, se non esiste viene creato
 * e se esiste gia' viene troncato;
 * 3)   sono i diritti di accesso al pathname.
 *
 * return:
 * -1 se c'e' stato un errore, altrimenti un intero per il file descriptor.
 *
 */
void scrivi1n(int n, char *nome) {
    // apre file in scrittura
    int fd = open(nome, O_WRONLY | O_CREAT | O_TRUNC, 0666);    // apre il file con un certo nome,
    if (fd < 0)
        die("Errore creazione file");
    // scrive valori sul file
    for (int i = 1; i <= n; i++) {
        ssize_t e = write(fd, &i, sizeof(int)); // scrive su f il contenuto di i
        if (e != sizeof(int)) {
            perror("Errore scrittura file");
            exit(1);
        }
    }
    // chiude file
    int e = close(fd);
    if (e != 0) {
        perror("Errore chiusura file");
        exit(1);
    }
}


int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Uso:\n\t%s n nomefile\n\n", argv[0]);
        exit(1);
    }
    int n = atoi(argv[1]);
    if (n <= 0) {
        fprintf(stderr, "Inserisci un intero positivo\n");
        exit(1);
    }
    scrivi1n(n, argv[2]);
}
    
    
    
