/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import models.Clock;
import models.Player;

/*Start() uses two players.
  Each player moves one after the other
*/
public interface IGame {
    public void  start(Player[] players);
    
    public void playersMove(Player[] players, Clock c);

}
