package proj1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class DynamicTreeDemo extends JPanel {

    private DynamicTree treePanel;
    main temp = null;

    public DynamicTreeDemo(main m) {
        super(new BorderLayout());
        temp = m;
        // Create the components.
        treePanel = new DynamicTree();
        populateTree(treePanel, m);
        // Lay everything out.
        treePanel.setPreferredSize(new Dimension(300, 150));
        add(treePanel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0, 3));
        add(panel, BorderLayout.SOUTH);
    }

    public void populateTree(DynamicTree treePanel, main tree_Obj) {

        DefaultMutableTreeNode p1;
        for (int root_index = 0; root_index < tree_Obj.table.tree.size(); root_index++) {
            p1 = treePanel.addroot(null, tree_Obj.table.tree.get(root_index).root.data);
            tree_Obj.table.tree.get(root_index).display(tree_Obj.table.tree.get(root_index).root);
            for (int childe_index = 0; childe_index < tree_Obj.table.tree.get(root_index).BST_item.size(); childe_index++) {
                treePanel.addroot(p1, tree_Obj.table.tree.get(root_index).BST_item.get(childe_index).toString());
            }
        }

    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("DynamicTreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        DynamicTreeDemo newContentPane = new DynamicTreeDemo(temp);
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}

class DynamicTree extends JPanel {

    protected DefaultMutableTreeNode rootNode;
    protected DefaultTreeModel treeModel;
    protected JTree tree;

    public DynamicTree() {
        super(new GridLayout(1, 0));

        rootNode = new DefaultMutableTreeNode("Root Node");
        treeModel = new DefaultTreeModel(rootNode);

        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    public DefaultMutableTreeNode addroot(DefaultMutableTreeNode parent,
            Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
            Object child, boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

        // Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

}
