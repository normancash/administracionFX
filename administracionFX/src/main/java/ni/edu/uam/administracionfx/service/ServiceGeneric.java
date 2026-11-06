package ni.edu.uam.administracionfx.service;

import ni.edu.uam.administracionfx.dao.IDao;
import ni.edu.uam.administracionfx.dao.ImplDao;

public class ServiceGeneric {

    protected IDao dao;
    public ServiceGeneric(IDao dao) {
        this.dao = new ImplDao();
    }
}
