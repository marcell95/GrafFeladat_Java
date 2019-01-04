/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.petrik.graffeladat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MasterZeigh
 */
public class Grafok {
    //Itt olvasom be a gráfokat a feladatokhoz, 
    //és alakítom át a kellő formátumúra, többnyire
    
    //csúcsmátrixok, de a feladathoz nem jó a formátum, Graf osztályú kell;
    //a Java gyakorlaton így oldottuk meg a beolvasást, és nekem
    //átláthatóbb volt úgy, ha nem egyszerre olvasom be és alakítom át,
    //hanem külön metódusokban...
    
    private List<List<Integer>> iranyitottL = readGraph("directed_graph.txt");
    private List<List<Integer>> iranyitatlanL = readGraph("undirected_graph.txt");
    
    private Graf iranyitottG = konvertalas(iranyitottL);
    private Graf iranyitatlanG = konvertalas(iranyitatlanL);

    public Graf getIranyitottG() {
        return iranyitottG;
    }

    public Graf getIranyitatlanG() {
        return iranyitatlanG;
    }
    
    private Graf konvertalas(List<List<Integer>> tempLista){
        Graf tempGraf = new Graf(tempLista.size());
        
        for (int i = 0; i < tempLista.size(); i++) {
            for (int j = 0; j < tempLista.get(i).size(); j++) {
                El el = new El(i, j, tempLista.get(i).get(j));
                tempGraf.getElek().add(el);
            }
        }
        
        return tempGraf;
    }
    
    private List<List<Integer>> readGraph(String FileName){
        
        List<List<Integer>> lista = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(FileName))){
            String line;
            
            while((line = br.readLine())!= null){
                String[] s = line.split(" ");
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < s.length; i++) {
                    temp.add(Integer.parseInt(s[i]));
                }
                lista.add(temp);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Nincs meg a forrás txt!");
        }catch (IOException ex) {
            System.out.println("Olvasási hiba!");
        }
        return lista;
    }
    
    
    
    
}
