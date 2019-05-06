<?php
namespace App\Controller\Rest;

use FOS\RestBundle\Controller\Annotations as Rest;
use FOS\RestBundle\Controller\FOSRestController;
use App\Document\Device;
use Doctrine\ODM\MongoDB\DocumentManager;
use Symfony\Component\HttpFoundation\Response;
use FOS\RestBundle\View\View;
use Symfony\Component\HttpFoundation\Request;

class RestController extends FOSRestController
{
    /**
     * @Rest\Post("api/create-device")
     * @param Request $request
     * @param DocumentManager
     * @return View
     */
    public function createDevice(Request $request, DocumentManager $dm): \FOS\RestBundle\View\View
    { 
        $device = new Device();
        $device->setName($request->get('name'));
       
        return View::create($device, Response::HTTP_CREATED);
    }
    
    /**
     * @Rest\Post("api/devices")
     * @param Request $request
     * @param DocumentManager
     * @return View
     */
    public function getDevices(DocumentManager $dm): \FOS\RestBundle\View\View
    { 
        return View::create($dm->getRepository(Device::class)->findAll(), Response::HTTP_CREATED);
    }
}
