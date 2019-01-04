/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.petrik.graffeladat;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author MasterZeigh
 */
public class SzelessegiBejaras {
    private int V;   // Csúcsok száma 
    private LinkedList<Integer> adj[];
   
    SzelessegiBejaras(Graf tempGraf, int kezdocsucs) 
    { 
        V = tempGraf.getCsucsok().size(); 
            adj = new LinkedList[V]; 
            for (int i=0; i<V; ++i) 
                adj[i] = new LinkedList(); 
            feltolt(tempGraf);
            
            System.out.println("A szélességi bejárása következik "+ 
                           "(kiindulási csúcsa: "+ kezdocsucs +"):"); 
  
            BFS(kezdocsucs); System.out.println("\n------------\n");
    } 
    
    private void feltolt(Graf tempGraf){
            int Elekhossz = tempGraf.getElek().size();
            
            for (El el : tempGraf.getElek()) {
                //ha 0 egy él súlya, akkor nem adja hozzá,
                //mert ha a súly 0 akkor ott nincs él(legalábbis itt)
                if (el.getSuly() != 0) {
                    addEdge(el.getCsucs1(), el.getCsucs2());
                }
            }
        }
  
    // Metódus egy él hozzá adásához a gráfba
    void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 
  
    // Breadth First Search rövidítése
    void BFS(int s) 
    { 
        // Minden csúcsot nem meglátogatottra kell állítani,
        // alapértelmezetten false
        boolean visited[] = new boolean[V]; 
  
        //sor létrehozása
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // aktuális csúcs meglátogatottá állítása és sorba helyezése
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // első érték kivétele a sorból, és kiiratása
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Minden csúcs megnézése az éppen kivett csúcsal érintkezve. 
            // Ha egy szomszédos csúcs mgé nem volt meglátogatva,
            // átállítja true-ra a meglátogatottsági értékét
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
}
