// spec.js
describe('Prueba pantalla principal', function() {
    it('Titulo', function() {
      browser.get('http://localhost:4200/');
  
      expect(browser.getTitle()).toEqual('Front');
    });
  });

  describe('Boton nueva persona', function() {
    it('crear persona', function() {
      browser.get('http://localhost:4200/');
  
      element(by.id('botonNuevo')).click();
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-persona'); 
    });
  });

  describe('Boton nueva cita', function() {
    it('redirigir crear persona', function() {
      browser.get('http://localhost:4200/citas');
  
      element(by.id('botonNuevo')).click();
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-cita'); 
    });
  });

  describe('Creacion persona', function() {
    it('creacion nueva persona', function() {
      browser.get('http://localhost:4200/crear-persona');
      element(by.id('campoIdentificacion')).sendKeys(1097400317);
      element(by.id('campoNombre')).sendKeys("Felipe");
      element(by.id('campoEdad')).sendKeys(26);
      element(by.id('botonCrear')).click();
      element(by.buttonText('OK')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/'); 
    });
  });

  describe('Creacion cita', function() {
    it('creacion nueva cita', function() {
      browser.get('http://localhost:4200/crear-cita');
      element(by.id('campoFecha')).sendKeys("11/11/2019");
      element(by.cssContainingText('option', 'Felipe')).click();
      element(by.id('botonCrearCita')).click();
      element(by.buttonText('OK')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/'); 
    });
  });

  describe('Eliminar cita', function() {
    it('Eliminacion cita', function() {
      browser.get('http://localhost:4200/citas');
      element(by.id('botonEliminar')).click();
      element(by.buttonText('SI')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/citas'); 
    });
  });

  describe('Eliminar Persona', function() {
    it('Eliminacion Persona', function() {
      browser.get('http://localhost:4200/');
      element(by.id('botonEliminar')).click();
      element(by.buttonText('SI')).click();
      
  
      expect(browser.getCurrentUrl()).toBe('http://localhost:4200/'); 
    });
  });