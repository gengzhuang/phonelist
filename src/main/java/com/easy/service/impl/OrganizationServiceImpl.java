package com.easy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easy.commons.result.Tree;
import com.easy.mapper.OrganizationMapper;
import com.easy.model.Organization;
import com.easy.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public List<Tree> findTree() {
        List<Tree> trees = new ArrayList<Tree>();

        List<Organization> organizationFather = organizationMapper.findOrganizationAllByPidNull();

        if (organizationFather != null) {
            for (Organization organizationOne : organizationFather) {
                Tree treeOne = new Tree();

                treeOne.setId(organizationOne.getId());
                treeOne.setText(organizationOne.getName());
                treeOne.setIconCls(organizationOne.getIcon());

                List<Organization> organizationSon = organizationMapper.findOrganizationAllByPid(organizationOne.getId());

                if (organizationSon != null) {
                    List<Tree> tree = new ArrayList<Tree>();
                    for (Organization organizationTwo : organizationSon) {
                        Tree treeTwo = new Tree();
                        treeTwo.setId(organizationTwo.getId());
                        treeTwo.setText(organizationTwo.getName());
                        treeTwo.setIconCls(organizationTwo.getIcon());
                        tree.add(treeTwo);
                    }
                    treeOne.setChildren(tree);
                } else {
                    treeOne.setState("closed");
                }
                trees.add(treeOne);
            }
        }
        return trees;
    }

    @Override
    public List<Organization> findTreeGrid() {
        return organizationMapper.findOrganizationAll();
    }

    @Override
    public void addOrganization(Organization organization) {
        organizationMapper.insert(organization);
    }

    @Override
    public Organization findOrganizationById(Long id) {
        return organizationMapper.findOrganizationById(id);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationMapper.updateOrganization(organization);
    }

    @Override
    public void deleteOrganizationById(Long id) {
        organizationMapper.deleteOrganizationById(id);
    }

}
