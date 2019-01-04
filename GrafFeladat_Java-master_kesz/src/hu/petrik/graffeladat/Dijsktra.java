/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.petrik.graffeladat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MasterZeigh
 */
public class Dijsktra {
    
    public void legrovidebbUt(Graf tempGraf, int kezdocsucs){
        
        int Meret = tempGraf.getCsucsok().size();
        
        // A visszatérési lista. dist[i] a legrövidebb 
        // tartalmazza majd a kezdőcsúcs és i között 
        List<Integer> dist = new ArrayList<>();
        //shortest path tree set, avagy legrövidebb útvonalfa lista/tömb
        List<Boolean> sptset = new ArrayList<>();
    
        for (int i = 0; i < Meret; i++) {
            dist.add(Integer.MAX_VALUE);
            sptset.add(false);
        }
        dist.set(kezdocsucs, 0);
        
        for (int i = 0; i < Meret-1; i++) {
            int uv = minDistance(dist, sptset);
            sptset.set(uv, true);
            
            //a sok if egy maradvány a bugvadászat utánról, gondoltam jól jöhet még később
            for (int j = 0; j < Meret; j++) {
                if (!sptset.get(j)){
                    if(getSulyFromElek(tempGraf.getElek(), uv, j) != 0) {
                        if (dist.get(uv) != Integer.MAX_VALUE) {
                            if (dist.get(uv) + getSulyFromElek(tempGraf.getElek(), uv, j) < dist.get(j)) {
                                dist.set(j, dist.get(uv) + getSulyFromElek(tempGraf.getElek(), uv, j)) ; 
                            }    
                        }
                    }
                }
            }
        }
        
        kiiratas(dist, Meret);
    }
    
    private int minDistance(List<Integer> dist, List<Boolean> sptset){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        for (int i = 0; i < dist.size(); i++) 
            if (sptset.get(i)== false && dist.get(i) <= min) {
                min = dist.get(i);
                min_index = i;
            }
        
        return min_index;
    }
    
    //újabb konvertálási nehézségek végett
    private int getSulyFromElek(List<El> elek, int uv, int j){
        int suly = 0;
        
        for (El el : elek) {
                if (el.getCsucs1() == uv && el.getCsucs2() == j) {
                    suly = el.getSuly();
                }
            }
        return suly;
    }
    
    private void kiiratas(List<Integer> dist, int n){
        System.out.println("Csúcs   Távolság a kezdőcsúcstól");
        for (int i = 0; i < dist.size(); i++) {
            System.out.println(i+"        " + dist.get(i));
        }
    }
}
