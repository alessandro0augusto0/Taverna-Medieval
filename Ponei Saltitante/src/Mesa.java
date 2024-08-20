import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Mesa {
    private final int id;
    private final Lock lock = new ReentrantLock();
    private int clientesNaMesa = 0;
    private final int capacidade = 4;
    private boolean inspecionada = true;

    public Mesa(int id) {
        this.id = id;
    }

    public boolean ocupar() {
        if (lock.tryLock()) {
            try {
                if (clientesNaMesa < capacidade) {
                    clientesNaMesa++;
                    inspecionada = false;
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public void liberar() {
        lock.lock();
        try {
            if (clientesNaMesa > 0) {
                clientesNaMesa--;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean estaLivre() {
        return clientesNaMesa == 0;
    }

    public boolean estaInspecionada() {
        return inspecionada;
    }

    public void inspecionar() {
        lock.lock();
        try {
            inspecionada = true;
        } finally {
            lock.unlock();
        }
    }

    public int getId() {
        return id;
    }

    public int getClientesNaMesa() {
        return clientesNaMesa;
    }
}