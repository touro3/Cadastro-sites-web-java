import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroSites {
    private List<Site> sites;

    public CadastroSites() {
        sites = new ArrayList<>();
    }

    public void adicionarSite(Site site) {
        sites.add(site);
        salvarSites();
    }

    public void listarSites() {
        for (Site site : sites) {
            System.out.println("Descrição: " + site.getDescricao());
            System.out.println("URL: " + site.getUrl());
            System.out.println("Data de Cadastro: " + site.getDataCadastro());
            System.out.println();
        }
    }

    public void salvarSites() {
        try {
            FileOutputStream fileOut = new FileOutputStream("sites.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sites);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarSites() {
        try {
            FileInputStream fileIn = new FileInputStream("sites.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sites = (List<Site>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}