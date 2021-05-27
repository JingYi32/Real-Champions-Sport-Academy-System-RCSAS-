
package rcsas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface tableMouseListener extends MouseListener{
    void mouse(MouseEvent e);
    
    @Override
    default void mouseClicked(MouseEvent e) {
        mouse(e);
    }
    @Override
    default void mousePressed(MouseEvent e) {
        mouse(e);
    }
    @Override
    default void mouseReleased(MouseEvent e) {
    }
    @Override
    default void mouseEntered(MouseEvent e) {
    }
    @Override
    default void mouseExited(MouseEvent e) {
    } 
}
