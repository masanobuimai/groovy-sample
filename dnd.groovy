import groovy.swing.SwingBuilder

import static javax.swing.WindowConstants.*
import static java.awt.dnd.DnDConstants.*
import static java.awt.datatransfer.DataFlavor.*

import javax.swing.DefaultListModel
import java.awt.dnd.*

def myList

SwingBuilder.build {
  frame(title: "DnD", pack: true, visible: true,
        defaultCloseOperation: EXIT_ON_CLOSE) {
    scrollPane() {
      myList = list(model: new DefaultListModel(),
                    dropTarget: new DropTarget(myList, ACTION_COPY_OR_MOVE, [
                                               drop: {e ->
                                                 e.acceptDrop(ACTION_COPY_OR_MOVE)
                                                 myList.model.removeAllElements()
                                                 try {
                                                   if (e.isDataFlavorSupported(javaFileListFlavor)) {
                                                     def trans = e.transferable
                                                     trans.getTransferData(javaFileListFlavor).each {
                                                       myList.model.addElement(it)
                                                     }
                                                   }
                                                 } catch (ex) { e.dropComplete(false) }
                                               },
                                               dragEnter: {e ->
                                                 e.acceptDrag(ACTION_COPY_OR_MOVE)
                                               } ] as DropTargetAdapter, true))
    }
  }
}